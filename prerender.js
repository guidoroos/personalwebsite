import puppeteer from 'puppeteer';
import fs from 'fs-extra'; // fs-extra ipv fs
import path from 'path';
import { fileURLToPath } from 'url';

const __filename = fileURLToPath(import.meta.url);
const __dirname = path.dirname(__filename);

const baseUrl = 'https://guidoroos.nl';
const projectIds = [
    "personal-website-compose",
    "autochef-cooking-app",
    "banking-right-io",
    "natuurmonumenten-app",
    "van-lanschot-android",
    "bnp-paribas-io",
    "viaplay-viascore",
    "duivelaar-ble",
    "abn-amro-private-banking"
];

const routes = [
    '/',
    '/projects',
    ...projectIds.map(id => `/projects/${id}`)
];

(async () => {
  const browser = await puppeteer.launch();
  const page = await browser.newPage();

  const languages = ['nl', 'en'];

  for (const lang of languages) {
      // Stap 1: Forceer de browser-taal voor de hele sessie van deze taal
      await page.evaluateOnNewDocument((l) => {
          Object.defineProperty(navigator, 'language', { get: () => l });
          Object.defineProperty(navigator, 'languages', { get: () => [l] });
      }, lang === 'nl' ? 'nl-NL' : 'en-US');

  for (const route of routes) {

      await page.goto('http://localhost:8080/index.html', { waitUntil: 'networkidle0' });

      // Stap 2: Injecteer de URL in de browser van Puppeteer
      await page.evaluate((targetRoute) => {
          window.history.pushState({}, '', targetRoute);
          window.dispatchEvent(new Event('popstate')); // Dwing Kotlin om parseUrlToPage() te doen
      }, route);

      // Stap 3: Wacht tot de Kotlin-render de DOM heeft aangepast
      await new Promise(r => setTimeout(r, 5000));

      // Stap 4: Trek de HTML eruit
      const html = await page.content();

      // Stap 5: Schrijf dit naar de map /projects/index.html
      const outputPath = path.join(__dirname, 'dist', lang, route, 'index.html');
      fs.ensureDirSync(path.dirname(outputPath));
      fs.writeFileSync(outputPath, html);

    }
  }

 generateSitemap(routes);
  await browser.close();
})();



// Roep dit aan na je loop:
await generateSitemap(routes);
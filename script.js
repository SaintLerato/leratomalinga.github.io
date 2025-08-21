
const y = document.getElementById('year'); if (y) y.textContent = new Date().getFullYear();
const btn = document.getElementById('themeToggle');
const root = document.documentElement;
const mode = localStorage.getItem('theme') || 'dark';
if (mode === 'light') root.classList.add('light');
btn?.addEventListener('click', () => {
  root.classList.toggle('light');
  localStorage.setItem('theme', root.classList.contains('light') ? 'light' : 'dark');
});

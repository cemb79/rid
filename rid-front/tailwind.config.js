module.exports = {
  future: {
    // removeDeprecatedGapUtilities: true,
    // purgeLayersByDefault: true,
  },
  purge: [
    './public/**/*.html',
    './src/**/*.vue',
  ],
  theme: {
    extend: {
      colors: {
        'primary': '#112773',
        'secondary': '#EBEEF5'
      }
    },
  },
  variants: {},
  plugins: [],
}

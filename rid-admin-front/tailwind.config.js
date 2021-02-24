module.exports = {
  future: {
    // removeDeprecatedGapUtilities: true,
    // purgeLayersByDefault: true,
  },
  purge: {
    enabled: true,
    content: [
      './public/**/*.html',
      './src/**/*.vue',
    ]
  },
  theme: {
    extend: {
      colors: {
        'primary': '#112773',
        'secondary': '#EBEEF5'
      },
      fontFamily: {
        sans: ['Helvetica', 'Arial', 'sans-serif']
      },
      textColor: {
        'primary': '#6B7280'
      }
    },
  },
  variants: {},
  plugins: [],
}

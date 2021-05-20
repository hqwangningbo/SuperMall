module.exports = {
  plugins: {
    autoprefixer: {},
    "postcss-px-to-viewport":{
      viewportWidth: 375, //视口的宽度，开发按照iphone(375*667)用其他设备就可以把高度按照比例设成合适的vw
      viewportHeight: 667,//视口的高度
      unitPrecision: 5, //转成vw保留5位小数
      viewportUnit: 'vw', //指定需要转换的视窗单位，建议使用vw
      selectorBlackList: ['ignore','tab-bar','tab-bar-item'],//指定不需要转换的css类
      minPixelValue: 1, //小于等于1px，不进行转换
      mediaQuery: false,//允许在媒体查询中进行转换
      exclude:[] //也可以用这个来忽略，里面必须是正则表达式
      // 1. ^abc：必须是以abc开头
      // 2. abc$:必须是以abc结尾
      // 3.
    }
  }
}

# MaterialShapeDrawable

Material Shapes的基本可绘制类，用于处理生成路径的阴影、立面、比例和颜色。

### 重要的构造方法

`MaterialShapeDrawable(ShapePathModel shapePathModel)`ShapePathModel 已经被遗弃，用ShapeAppearanceModel替代。

`MaterialShapeDrawable(ShapeAppearanceModel shapeAppearanceModel)` ShapeAppearanceModel这个类对形状的边角进行建模，MaterialShapeDrawable使用它来生成和渲染视图背景的形状。

### CompatibilityShadowMode 接口

用于决定何时绘制兼容阴影

1、`SHADOW_COMPAT_MODE_ALWAYS` 总是画假阴影，永远不绘制本地z轴(native elevation)阴影

2、`SHADOW_COMPAT_MODE_DEFAULT` 尝试绘制本地z轴(native elevation)阴影，否则绘制假阴影

3、`SHADOW_COMPAT_MODE_NEVER` 永远不绘制假阴影
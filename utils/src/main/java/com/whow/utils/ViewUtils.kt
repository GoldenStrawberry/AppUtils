package com.whow.utils

import android.content.Context
import android.graphics.Color
import android.graphics.Paint
import android.view.View
import android.view.ViewGroup
import androidx.annotation.ColorRes
import com.google.android.material.shape.CornerFamily
import com.google.android.material.shape.MaterialShapeDrawable
import com.google.android.material.shape.RoundedCornerTreatment
import com.google.android.material.shape.ShapeAppearanceModel

/**
 * 给View添加圆角和阴影
 * @param context 上下文
 * @param view 要被添加阴影的View
 * @param cornerSize 四角剪切的弧度
 * @param elevationValue z轴的高度
 */
fun addShadowToView(
    context: Context,
    view: View,
    @ColorRes shadowColor: Int,
    cornerSize: Float,
    elevationValue: Float
) {

    val shapeModel = ShapeAppearanceModel.builder().apply {
        setAllCorners(RoundedCornerTreatment()) // 设置所有角落处理方式//RoundedCornerTreatment圆角处理
        setAllCornerSizes(cornerSize) // 四个拐角设置处理拐角大小
        // 等同于 => setAllCorners(CornerFamily.ROUNDED, cornerSize)
    }.build()
    val shapeDrawable = MaterialShapeDrawable(shapeModel).apply {
        setTint(Color.WHITE)
        paintStyle = Paint.Style.FILL
        shadowCompatibilityMode = MaterialShapeDrawable.SHADOW_COMPAT_MODE_ALWAYS
        initializeElevationOverlay(context)
        setShadowColor(context.getColor(shadowColor))
        elevation = elevationValue
    }
    if (view.parent != null) {
        // 对于导致凹形状的边缘处理，
        // 父视图必须通过调用android.view.viewgroup.setclipchildren (boolean)，
        // 或通过在xml中设置' android:clipChildren="false"来禁用子视图的剪切。
        (view.parent as ViewGroup).clipChildren = false
        // ' clipToPadding '也可能需要为false，如果父节点上有任何可能与阴影相交的填充。
        (view.parent as ViewGroup).clipToPadding = false
    }
    view.background = shapeDrawable
}
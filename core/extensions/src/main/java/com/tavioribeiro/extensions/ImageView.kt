package core.extensions

import android.animation.ValueAnimator
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.ColorMatrix
import android.graphics.ColorMatrixColorFilter
import android.graphics.Paint
import android.graphics.drawable.BitmapDrawable
import android.os.Build
import android.widget.ImageView
import androidx.annotation.RequiresApi


val defaultOriginalMatriz = floatArrayOf(
    1.1f, 0f, 0f, 0f, 0f,
    0f, 1.1f, 0f, 0f, 0f,
    0f, 0f, 1.1f, 0f, 0f,
    0f, 0f, 0f, 1f, 0f
)
val defaultFinalMatriz = floatArrayOf(
    0.8f, 0f, 0f, 0f, 0f,
    0f, 0.8f, 0f, 0f, 0f,
    0f, 0f, 0.8f, 0f, 0f,
    0f, 0f, 0f, 1f, 0f
)




/**
 * Aplica uma animação de overlay (sobreposição) a ImageView, clareando a imagem.
 *
 * Uso:
 * // Mostrar overlay com matrizes padrão e duração de 300ms.
 * myImageView.showOverlay()
 *
 * // Mostrar overlay com matrizes personalizadas.
 * myImageView.showOverlay(
 *     originalMatriz = floatArrayOf(...),
 *     finalMatriz = floatArrayOf(...)
 * )
 *
 * ```
 *
 * @param originalMatriz Matriz de cores original da imagem.
 * @param finalMatriz Matriz de cores final da animação.
 */
fun ImageView.showOverlay(
    originalMatriz: FloatArray = defaultOriginalMatriz,
    finalMatriz: FloatArray = defaultFinalMatriz
) {
    val animation = ValueAnimator.ofFloat(0f, 1f)
    animation.duration = 300

    animation.addUpdateListener { valueAnimator ->
        val fraction = valueAnimator.animatedFraction
        val interpolatedMatriz = FloatArray(originalMatriz.size)
        for (i in originalMatriz.indices) {
            interpolatedMatriz[i] =
                originalMatriz[i] + (finalMatriz[i] - originalMatriz[i]) * fraction
        }
        val matrizCor = ColorMatrix(interpolatedMatriz)
        val filtroCor = ColorMatrixColorFilter(matrizCor)
        this.colorFilter = filtroCor
    }
    animation.start()
}








/**
 * Remove a animação de overlay (sobreposição) da ImageView, restaurando a cor original da imagem.
 *
 * Uso:
 * // Remover overlay com matrizes padrão e duração de 300ms.
 * myImageView.hideOverlay()
 *
 * // Remover overlay com matrizes personalizadas.
 * myImageView.hideOverlay(
 *     originalMatriz = floatArrayOf(...),
 *     finalMatriz = floatArrayOf(...)
 * )
 *
 * ```
 *
 * @param originalMatriz Matriz de cores original da imagem.
 * @param finalMatriz Matriz de cores final da animação.
 */
fun ImageView.hideOverlay(
    originalMatriz: FloatArray = defaultOriginalMatriz,
    finalMatriz: FloatArray = defaultFinalMatriz
) {
    val animation = ValueAnimator.ofFloat(0f, 1f)
    animation.duration = 300

    animation.addUpdateListener { valueAnimator ->
        val fraction = valueAnimator.animatedFraction
        val interpolatedMatriz = FloatArray(originalMatriz.size)
        for (i in originalMatriz.indices) {
            interpolatedMatriz[i] =
                finalMatriz[i] + (originalMatriz[i] - finalMatriz[i]) * fraction
        }
        val matrizCor = ColorMatrix(interpolatedMatriz)
        val filtroCor = ColorMatrixColorFilter(matrizCor)
        this.colorFilter = filtroCor
    }
    animation.start()
}







/**
 * Reseta o Color Filter da ImageView para o estado final da animação de overlay.
 *
 * Uso:
 * // Reseta o Color Filter com a matriz padrão.
 * myImageView.resetColorFilter()
 *
 * // Reseta o Color Filter com uma matriz personalizada.
 * myImageView.resetColorFilter(finalMatriz = floatArrayOf(...))
 *
 * ```
 *
 * @param finalMatriz Matriz de cores final da animação de overlay.
 */
fun ImageView.resetColorFilter(finalMatriz: FloatArray = defaultFinalMatriz) {
    this.colorFilter = ColorMatrixColorFilter(finalMatriz)
}







package core.extensions

import android.webkit.MimeTypeMap
import java.io.File

fun File.getMimeType(): String? {
    return MimeTypeMap.getSingleton().getMimeTypeFromExtension(this.extension)
}
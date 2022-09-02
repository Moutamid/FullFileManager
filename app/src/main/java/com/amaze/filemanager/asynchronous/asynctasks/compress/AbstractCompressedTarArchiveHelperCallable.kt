/*
 * Copyright (c) 2022 FullDive
 *  This program is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *
 *  This program is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License
 *  along with this program.  If not, see <https://www.gnu.org/licenses/>.
 */

package com.amaze.filemanager.asynchronous.asynctasks.compress

import android.content.Context
import com.amaze.filemanager.filesystem.compressed.extractcontents.Extractor
import org.apache.commons.compress.archivers.tar.TarArchiveInputStream
import org.apache.commons.compress.compressors.CompressorInputStream
import java.io.InputStream
import java.lang.reflect.Constructor

abstract class AbstractCompressedTarArchiveHelperCallable(
    context: Context,
    filePath: String,
    relativePath: String,
    goBack: Boolean
) :
    AbstractCommonsArchiveHelperCallable(context, filePath, relativePath, goBack) {

    private val compressorInputStreamConstructor: Constructor<out CompressorInputStream>

    init {
        compressorInputStreamConstructor = getCompressorInputStreamClass()
            .getDeclaredConstructor(InputStream::class.java)
        compressorInputStreamConstructor.isAccessible = true
    }

    /**
     * Subclasses implement this method to specify the [CompressorInputStream] class to be used. It
     * will be used to create the backing inputstream beneath [TarArchiveInputStream] in
     * [createFrom].
     *
     * @return Class representing the implementation will be handling
     */
    abstract fun getCompressorInputStreamClass(): Class<out CompressorInputStream>

    override fun createFrom(inputStream: InputStream): TarArchiveInputStream {
        return runCatching {
            TarArchiveInputStream(compressorInputStreamConstructor.newInstance(inputStream))
        }.getOrElse {
            throw Extractor.BadArchiveNotice(it)
        }
    }
}

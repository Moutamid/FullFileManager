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

package com.amaze.filemanager.test

import android.content.Context
import android.util.Base64
import com.amaze.filemanager.utils.PasswordUtil
import org.robolectric.annotation.Implementation
import org.robolectric.annotation.Implements
import java.io.IOException
import java.security.GeneralSecurityException
import javax.crypto.Cipher
import javax.crypto.KeyGenerator
import javax.crypto.SecretKey
import javax.crypto.spec.GCMParameterSpec

@Implements(PasswordUtil::class)
class ShadowPasswordUtil {

    companion object {
        val INSTANCE = ShadowPasswordUtil()
        private const val ALGO_AES = "AES/GCM/NoPadding"
        private const val IV = "LxbHiJhhUXcj" // 12 byte long IV supported by android for GCM
    }

    private var secretKey: SecretKey

    /** Method handles encryption of plain text on various APIs  */
    @Implementation
    @Throws(GeneralSecurityException::class, IOException::class)
    fun encryptPassword(context: Context?, plainText: String): String {
        return aesEncryptPassword(plainText)
    }

    /** Method handles decryption of cipher text on various APIs  */
    @Implementation
    @Throws(GeneralSecurityException::class, IOException::class)
    fun decryptPassword(context: Context?, cipherText: String): String {
        return aesDecryptPassword(cipherText)
    }

    /** Helper method to encrypt plain text password  */
    @Throws(GeneralSecurityException::class)
    private fun aesEncryptPassword(plainTextPassword: String): String {
        val cipher = Cipher.getInstance(ALGO_AES)
        val gcmParameterSpec = GCMParameterSpec(128, IV.toByteArray())
        cipher.init(Cipher.ENCRYPT_MODE, secretKey, gcmParameterSpec)
        val encodedBytes = cipher.doFinal(plainTextPassword.toByteArray())
        return Base64.encodeToString(encodedBytes, Base64.DEFAULT)
    }

    /** Helper method to decrypt cipher text password  */
    @Throws(GeneralSecurityException::class)
    private fun aesDecryptPassword(cipherPassword: String): String {
        val cipher = Cipher.getInstance(ALGO_AES)
        val gcmParameterSpec = GCMParameterSpec(128, IV.toByteArray())
        cipher.init(Cipher.DECRYPT_MODE, secretKey, gcmParameterSpec)
        val decryptedBytes = cipher.doFinal(Base64.decode(cipherPassword, Base64.DEFAULT))
        return String(decryptedBytes)
    }

    init {
        val keyGen = KeyGenerator.getInstance("AES")
        keyGen.init(128)
        secretKey = keyGen.generateKey()
    }
}

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

package com.amaze.filemanager.filesystem.ssh

import net.schmizz.sshj.DefaultConfig
import org.bouncycastle.jce.provider.BouncyCastleProvider
import java.security.Security

/**
 * sshj [net.schmizz.sshj.Config] for our own use.
 *
 *
 * Borrowed from original AndroidConfig, but also use vanilla BouncyCastle from the start
 * altogether.
 *
 * @see net.schmizz.sshj.Config
 *
 * @see net.schmizz.sshj.AndroidConfig
 */
class CustomSshJConfig : DefaultConfig() {

    companion object {
        /**
         * This is where we different from the original AndroidConfig. Found it only work if we remove
         * BouncyCastle bundled with Android before registering our BouncyCastle provider
         */
        @JvmStatic
        fun init() {
            Security.removeProvider("BC")
            Security.insertProviderAt(BouncyCastleProvider(), 0)
        }
    }
}

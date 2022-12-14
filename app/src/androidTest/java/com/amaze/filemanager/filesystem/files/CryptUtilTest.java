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

package com.amaze.filemanager.filesystem.files;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.amaze.filemanager.BuildConfig;
import com.amaze.filemanager.utils.PasswordUtil;

import android.content.Context;

import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.platform.app.InstrumentationRegistry;

@RunWith(AndroidJUnit4.class)
public class CryptUtilTest {

  private Context context;

  @Before
  public void setUp() {
    context = InstrumentationRegistry.getInstrumentation().getTargetContext();
  }

  @Test
  public void testIvValueIsCorrect() {
    assertEquals("LxbHiJhhUXcj", BuildConfig.CRYPTO_IV);
  }

  @Test
  public void testEncryptDecrypt() throws Exception {
    String password = "hackme";
    String encrypted = PasswordUtil.INSTANCE.encryptPassword(context, password);
    assertEquals(password, PasswordUtil.INSTANCE.decryptPassword(context, encrypted));
  }
}

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

package com.amaze.filemanager.filesystem.compressed.extractcontents

import org.junit.runner.RunWith
import org.junit.runners.Suite
import org.junit.runners.Suite.SuiteClasses

@RunWith(Suite::class)
@SuiteClasses(
    GzipExtractorTest::class,
    Bzip2ExtractorTest::class,
    LzmaExtractorTest::class,
    XzExtractorTest::class,
    TarGzExtractorTest::class,
    TgzExtractorTest::class,
    ZipExtractorTest::class,
    TarExtractorTest::class,
    RarExtractorTest::class,
    TarBzip2ExtractorTest::class,
    TarBzip2ExtractorTest2::class,
    TarLzmaExtractorTest::class,
    TarXzExtractorTest::class,
    SevenZipExtractorTest::class,
    SevenZipWithoutTimestampTest::class,
    PasswordProtectedRarTest::class,
    PasswordProtectedZipTest::class,
    PasswordProtected7ZipTest::class,
    ListPasswordProtected7ZipTest::class,
    ListPasswordProtectedRarTest::class,
    MultipartRarExtractorTest::class
)
class ExtractorTestSuite

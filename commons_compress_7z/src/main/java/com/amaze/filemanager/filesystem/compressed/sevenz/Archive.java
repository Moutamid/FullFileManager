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

package com.amaze.filemanager.filesystem.compressed.sevenz;

import java.util.BitSet;

class Archive {
  /// Offset from beginning of file + SIGNATURE_HEADER_SIZE to packed streams.
  long packPos;
  /// Size of each packed stream.
  long[] packSizes;
  /// Whether each particular packed streams has a CRC.
  BitSet packCrcsDefined;
  /// CRCs for each packed stream, valid only if that packed stream has one.
  long[] packCrcs;
  /// Properties of solid compression blocks.
  Folder[] folders;
  /// Temporary properties for non-empty files (subsumed into the files array later).
  SubStreamsInfo subStreamsInfo;
  /// The files and directories in the archive.
  SevenZArchiveEntry[] files;
  /// Mapping between folders, files and streams.
  StreamMap streamMap;

  @Override
  public String toString() {
    return "Archive with packed streams starting at offset "
        + packPos
        + ", "
        + lengthOf(packSizes)
        + " pack sizes, "
        + lengthOf(packCrcs)
        + " CRCs, "
        + lengthOf(folders)
        + " folders, "
        + lengthOf(files)
        + " files and "
        + streamMap;
  }

  private static String lengthOf(final long[] a) {
    return a == null ? "(null)" : String.valueOf(a.length);
  }

  private static String lengthOf(final Object[] a) {
    return a == null ? "(null)" : String.valueOf(a.length);
  }
}

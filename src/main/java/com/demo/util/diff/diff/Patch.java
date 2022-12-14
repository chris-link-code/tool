package com.demo.util.diff.diff;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.LinkedList;

/**
 * Class representing one patch operation.
 */
public class Patch {
    public LinkedList<Diff> diffs;
    public int start1;
    public int start2;
    public int length1;
    public int length2;

    /**
     * Constructor.  Initializes with an empty list of diffs.
     */
    public Patch() {
        this.diffs = new LinkedList<>();
    }

    /**
     * Emulate GNU diffs format.
     * Header: @@ -382,8 +481,9 @@
     * Indices are printed as 1-based, not 0-based.
     *
     * @return The GNU diff string.
     */
    public String toString() {
        String coords1, coords2;
        if (this.length1 == 0) {
            coords1 = this.start1 + ",0";
        } else if (this.length1 == 1) {
            coords1 = Integer.toString(this.start1 + 1);
        } else {
            coords1 = (this.start1 + 1) + "," + this.length1;
        }
        if (this.length2 == 0) {
            coords2 = this.start2 + ",0";
        } else if (this.length2 == 1) {
            coords2 = Integer.toString(this.start2 + 1);
        } else {
            coords2 = (this.start2 + 1) + "," + this.length2;
        }
        StringBuilder text = new StringBuilder();
        text.append("@@ -").append(coords1).append(" +").append(coords2)
                .append(" @@\n");
        // Escape the body of the patch with %xx notation.
        for (Diff aDiff : this.diffs) {
            switch (aDiff.operation) {
                case INSERT -> text.append('+');
                case DELETE -> text.append('-');
                case EQUAL -> text.append(' ');
            }
            text.append(URLEncoder.encode(aDiff.text, StandardCharsets.UTF_8).replace('+', ' '))
                    .append("\n");
        }
        return DiffMatchPatch.unescapeForEncodeUriCompatability(text.toString());
    }
}

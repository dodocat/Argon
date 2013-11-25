package org.quanqi.argon.base;

import android.util.Log;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * By jingquanqi on 10/26/13.
 */
public class FileHelper {

    /**
     * Read all content in a in InputStream.
     * @param is
     * @return
     * @throws IOException
     */
    public static String ReadAll(InputStream is) throws IOException {
        StringBuilder content = new StringBuilder("");
        byte[] buffer = new byte[1024];
        int len = is.read(buffer);
        while ( len != -1) {
            content.append(new String(buffer,0, len));
            len = is.read(buffer);
        }
        return content.toString();
    }

}

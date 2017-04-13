package ru.job4j.loop;

/**
* Paint.
*
* @author Alex Proshak (olexandr_proshak@ukr.net)
* @version $Id$
* @since 0.1
*/
public class Paint {
	/**
	* Paint of the piramid.
	* @param h - height.
	* @return returning string of piramid.
	*/
	public String piramid(int h) {
		char c = 94;
        int width = h - 1 + h;
        StringBuilder str = new StringBuilder();
        StringBuilder st = new StringBuilder(width);
        //initialisation of builder.
		for (int i = 0; i < width; i++) {
            st.append(" ");
        }
        if (h == 1) {
            str.append(c);
        } else {
            for (int i = h; i > 1; i--) {
                for (int j = 0; j <= i; j++) {
                    st.setCharAt(i, c);
                    st.setCharAt(i + j, c);
                    st.setCharAt(i - j, c);
                    str.append(st);
                    str.append("\n");
					//easy code duplication.
                    for (int l = 0; l < width; l++) {
                        st.append(" ");
                    }
                }
            }
        }
        return str.toString();
    }
}
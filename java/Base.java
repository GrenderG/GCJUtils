import java.util.*;
import java.io.*;

/**
* GCJUtils
* Copyright (C) 2017  GrenderG, legomolina, svnacho, owniz
* 
* This program is free software: you can redistribute it and/or modify
* it under the terms of the GNU General Public License as published by
* the Free Software Foundation, either version 3 of the License, or
* (at your option) any later version.
*
* This program is distributed in the hope that it will be useful,
* but WITHOUT ANY WARRANTY; without even the implied warranty of
* MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
* GNU General Public License for more details.
*
* You should have received a copy of the GNU General Public License
* along with this program.  If not, see <http://www.gnu.org/licenses/>.
*/

public class Base {

    static String handleInput(int cs) {
        return "";
    }

    public static void main (String args[]) {
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int cases = sc.nextInt();

        for (int i = 1; i <= cases; i++) {
            System.out.println(handleInput(i));
        }
    }
}
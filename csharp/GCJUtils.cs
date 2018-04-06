using System;
using System.Collections.Generic;

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

namespace csharp
{
    public class GCJUtils
    {
        /**
        * Converts char numeric value (0-9) to its equal numerical value
        * @param char c Char we want to convert to int
        * @return int Char converted to its numerical value
        */
        public static int CharToInt (char c) {
            return c - '0';
        }

        /**
        * Replaces c1 for c2 and viceversa from string str
        * @param String str String input -the original one
        * @param char c1 One of the chars
        * @param char c2 The other one
        * @return String String output with replaced values
        */
        public static string Flip (string str, char c1, char c2) {
            return FlipFromOffset(str, c1, c2, 0);
        }

        /**
        * Replaces n1 for n2 and viceversa from one array of ints, 
        * int[] numbers
        * @param int[] numbers Array of ints input -the original one
        * @param int n1 One of the integers
        * @param int n2 The other one
        * @return int[] Array of ints ouput with replaced values
        */
        public static int[] Flip (int[] numbers, int n1, int n2) {
            return FlipFromOffset(numbers, n1, n2, 0);
        }

        /**
        * Replaces c1 for c2 and viceversa starting from an offset
        * @param String str String input -the original one
        * @param char c1 One of the chars
        * @param char c2 The other one
        * @param int offset Position where the flip starts 
        * @return String String output with replaced values
        */
        public static string FlipFromOffset (string str, char c1, char c2, int offset) {
            char[] chars = str.ToCharArray();
            for (int i = offset; i < chars.Length; i++)
                chars[i] = (chars[i] == c1) ? c2 : c1;
            return chars.ToString();
        }

        /**
        * Replaces n1 for n2 and viceversa starting from an offset
        * @param int[] numbers Array of ints input -the original one
        * @param int n1 One of the integers
        * @param int n2 The other one
        * @param int offset Position where the flip starts 
        * @return int[] Array of ints output with replaced values
        */
        public static int[] FlipFromOffset (int[] numbers, int n1, int n2, int offset) {
            for (int i = offset; i < numbers.Length; i++)
                numbers[i] = (numbers[i] == n1) ? n2 : n1;
            return numbers;
        }

         /**
        * Returns the different ciphers contained in n (no duplicates)
        * @param long n Number which we want to know the different ciphers 
        * @return int[] Different ciphers
        */
        public static int[] DifferentCiphers (long n) {
            int[] ciphers = SplitNumber(n), r;
            int it = 0;
            HashSet<int> knownC = new HashSet<int>();
            foreach (int c in ciphers)
                knownC.Add(c);
            r = new int[knownC.Count];
            foreach (int c in knownC)
                r[it++] = c;
            return r;
        }

        /**
        * Returns the different ciphers containd in n (no duplicates)
        * @param int n Number which we want to know the different ciphers
        * @return int[] Different ciphers
        */
        public static int[] DifferentCiphers (int n) {
            return DifferentCiphers(Convert.ToInt64(n));
        }

        /**
        * Splits a number into its ciphers
        * @param long n Number to split
        * @return int[] Array containing each cipher of n
        */    
        public static int[] SplitNumber (long n) {
            String nStr = n.ToString();
            int[] splitted = new int[nStr.Length];
            for (int i = 0; i < splitted.Length; i++)
                splitted[i] = CharToInt(nStr[i]);    
            return splitted;
        }

        /**
        * Splits a number into its ciphers
        * @param int n Number to split
        * @return int[] Array containing each cipher of n
        */
        public static int[] SplitNumber (int n) {
            return SplitNumber(Convert.ToInt64(n));
        }

        /**
        * Checks if a number is sorted in ascending order
        * @param long n Number to check its cipher order
        * @return boolean If it's sorted in ascending order or not
        */
        public static bool IsAscOrdered (long n) {
            int[] splitted = SplitNumber(n);
            for (int i = 0; i < splitted.Length - 1; i++)
                if (splitted[i] > splitted[i + 1])
                    return false;
            return true;
        }

        /**
        * Checks if a number is sorted in ascending order
        * @param int n Number to check its cipher order
        * @return boolean If it's sorted in ascending order or not
        */
        public static bool IsAscOrdered (int n) {
            return IsAscOrdered(Convert.ToInt64(n));
        }

        /**
        * Checks if a number is sorted in descending order
        * @param long n Number to check its cipher order
        * @return boolean If it's sorted in descending order or not
        */
        public static bool IsDescOrdered (long n) {
            int[] splitted = SplitNumber(n);
            for (int i = 0; i < splitted.Length - 1; i++)
                if (splitted[i] < splitted[i + 1])
                    return false;
            return true;
        }

        /**
        * Checks if a number is sorted in descending order
        * @param int n Number to check its cipher order
        * @return boolean If it's sorted in descending order or not
        */  
        public static bool IsDescOrdered (int n) {
            return IsDescOrdered(Convert.ToInt64(n));
        }

        /**
        * Count how many times oc appears in str
        * @param String str String we want to examine
        * @param String oc String we want to find in str
        * @return int Number of times that oc appears in str
        */
        public static int CountOccurences (string str, String oc) {
            return str.Length - str.Replace(oc, "").Length;
        }

        /**
        * Count how many times oc appears in str
        * @param String str String we want to examine
        * @param char oc char we want to find in str
        * @return int Number of times that oc appears in str
        */
        public static int CountOccurences (string str, char oc) {
            return CountOccurences(str, oc.ToString());
        }

        /**
        * Adds a character to a String, appending it to the right if it's 
        * alphabetically smaller (or equal) than the last char of str, left
        * otherwise
        * @param String str String we want to write in
        * @param char c char we want to add
        * @return String modified String
        */
        public static string AddCharToStringAlphaSorted (string str, char c) {
            int cInt = c;
            int cLastValueInt = str[str.Length - 1];

            if (c <= cLastValueInt)
                str += c;
            else if (c > cLastValueInt)
                str = c + str;

            return str;
        }
    }
}
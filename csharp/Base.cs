using System;

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
    public class Base
    {
        static string HandleInput(int cs) {
            return Console.ReadLine();
        }
        public static void Main(string[] args)
        {
            if (int.TryParse(Console.ReadLine(), out int cases)) {
                for (int i = 1; i <= cases; i++) {
                      Console.WriteLine(HandleInput(i));
                }
            }
            else {
                throw new ArgumentException("First line must be an integer");
            }
        }
    }
}

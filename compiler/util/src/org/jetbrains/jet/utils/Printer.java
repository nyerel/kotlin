/*
 * Copyright 2010-2012 JetBrains s.r.o.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.jetbrains.jet.utils;

import org.jetbrains.annotations.NotNull;

/**
* @author abreslav
*/
public class Printer {
    private static final String INDENTATION_UNIT = "    ";
    private String indent = "";
    private final StringBuilder out;

    public Printer(@NotNull StringBuilder out) {
        this.out = out;
    }

    public void println(Object... objects) {
        print(objects);
        out.append("\n");
    }

    public void print(Object... objects) {
        out.append(indent);
        printWithNoIndent(objects);
    }

    public void printWithNoIndent(Object... objects) {
        for (Object object : objects) {
            out.append(object);
        }
    }

    public void printlnWithNoIndent(Object... objects) {
        printWithNoIndent(objects);
        out.append("\n");
    }

    public void pushIndent() {
        indent += INDENTATION_UNIT;
    }

    public void popIndent() {
        if (indent.length() < INDENTATION_UNIT.length()) {
            throw new IllegalStateException("No indentation to pop");
        }

        indent = indent.substring(INDENTATION_UNIT.length());
    }
}

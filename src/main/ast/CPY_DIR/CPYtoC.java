package main.ast.CPY_DIR;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.regex.Pattern;

public class CPYtoC {
    private static final Pattern FUNCTION_PATTERN = Pattern.compile("^(\\w+\\s+)?\\w+\\s*\\(.*\\)\\s*:$");
    private static final Pattern CONTROL_FLOW_PATTERN = Pattern.compile("^(if|else if|while|for)\\s*\\(.*\\)\\s*:$");
    private static final Pattern ELSE_PATTERN = Pattern.compile("^else\\s*:$");
    private static final Pattern VAR_DECL_PATTERN = Pattern.compile("^\\w+\\s+\\w+\\s*(=\\s*.+)?$");
    private static final Pattern COMMENT_PATTERN = Pattern.compile("^//.*");
    public String finalC;


        public CPYtoC(String inputPath) throws IOException {
            String input = Files.readString(Paths.get(inputPath));
            finalC = convertSimpleLangToC(input);
//        System.out.println(converted);
        }

        private static String convertSimpleLangToC(String input) {
            String[] lines = input.split("\n");
            StringBuilder result = new StringBuilder();
            int indentLevel = 0;
            int totalBraces = 0;

            for (String line : lines) {

                if (line.trim().isEmpty()) {
                    result.append("\n");
                    continue;
                }

                String indentation = "    ".repeat(indentLevel);
                int total_tabs = 0;
                boolean hasChar = true;
                for (int i = 0; i < line.length(); i++) {
                    char ch = line.charAt(i);
                    if (ch == ' ' || ch == '\t') {
                        total_tabs++;
                    } else {
                        if (line.charAt(i) == '\n') {
                            hasChar = false;
                        }
                        break;
                    }
                }
                total_tabs /= 4;
                if (total_tabs < indentLevel && hasChar) {
                    if (!line.equals("end") || indentLevel > 1 && totalBraces > 0) {
                        indentLevel--;
                        totalBraces--;
                        result.setCharAt(result.length() - 1, '}');
                        while (indentLevel > total_tabs && indentLevel > 1 && totalBraces > 0) {
                            indentLevel--;
                            totalBraces--;
                            result.append("}");
                        }
                        result.append("\n");
                    }
                }

                line = line.trim();




                if (COMMENT_PATTERN.matcher(line).matches()) {
                    result.append(indentation).append(line).append("\n");
                    continue;
                }


                else if (FUNCTION_PATTERN.matcher(line).matches() && !line.startsWith("if") &&
                        !line.startsWith("while") && !line.startsWith("for") && !line.startsWith("else")) {
                    line = line.replaceFirst(":$", " {");
                    totalBraces++;
                    result.append(indentation).append(line).append("\n");
                    indentLevel++;
                }
                else if (CONTROL_FLOW_PATTERN.matcher(line).matches()) {
                    line = line.replaceFirst(":$", " {");
                    totalBraces++;
                    result.append(indentation).append(line).append("\n");
                    indentLevel++;
                }
                else if (ELSE_PATTERN.matcher(line).matches()) {
                    indentation = "    ".repeat(indentLevel);
                    line = line.replaceFirst(":$", " {");
                    totalBraces++;
                    result.append(indentation).append(line).append("\n");
                    indentLevel++;
                }
                else if (line.equals("end")) {
                    indentLevel--;
                    indentation = "    ".repeat(indentLevel);
                    if  (totalBraces > 0) {
                        result.append(indentation).append("}").append("\n");
                        totalBraces--;
                    }
                    else
                        result.append("\n");
                }
                else if (VAR_DECL_PATTERN.matcher(line).matches()) {
                    if (!line.endsWith(";")) line += ";";
                    result.append(indentation).append(line).append("\n");
                }
                else if (line.startsWith("return")) {
                    if (!line.endsWith(";")) line += ";";
                    result.append(indentation).append(line).append("\n");
                }
                else {
                    if (!line.endsWith(";") && !line.endsWith("{") && !line.endsWith("}")) {
                        line += ";";
                    }
                    result.append(indentation).append(line).append("\n");
                }
            }

            return result.toString();
        }
    }

# CPY Compiler Toolkit & Static Analyzer

![Java](https://img.shields.io/badge/Language-Java-orange)
![ANTLR](https://img.shields.io/badge/Parser-ANTLR4-red)
![Build](https://img.shields.io/badge/Build-Passing-brightgreen)
![License](https://img.shields.io/badge/License-MIT-blue)

## Overview
**CPY Compiler Toolkit** is a modular compiler infrastructure aimed at modernizing legacy C code. It features a robust **Transpiler** that converts standard C syntax into **CPY** (a Python-like C dialect), coupled with a powerful **Static Analysis Engine** designed to detect memory leaks, security vulnerabilities, and perform code optimizations.

This project demonstrates the full pipeline of compiler design: from Lexical Analysis and AST generation to Semantic Analysis and Vulnerability Detection.



## Key Features

### 🚀 1. C-to-CPY Transpiler (Source-to-Source)
Converts brace-based C code into indentation-based CPY syntax (Python-style), improving readability.
- **Scope Handling:** Replaces `{}` with indentation.
- **Syntax Modernization:** Removes semicolons `;` and introduces keywords like `end`.

### 🛡️ 2. Security & Vulnerability Analysis
Includes a custom-built static analyzer to catch critical runtime errors during compilation:
- **Memory Leak Detection:** Tracks `malloc` calls without corresponding `free`.
- **User-Controlled Malloc:** Detects security risks where memory size is dictated by unchecked user input.
- **Uninitialized Variables:** Prevents undefined behaviors.

### ⚡ 3. Advanced Optimization
implements compiler optimization techniques to reduce code size and improve execution flow:
- **Dead Code Elimination:** Removes unreachable statements (e.g., code after `return`).
- **Unused Entity Removal:** Detects and strips unused variables and functions.
- **Side-Effect Analysis:** Removes statements that do not impact the program state.

### 🔍 4. Semantic & Type Checking
- **Type Safety:** Ensures operand compatibility (e.g., preventing `int + string`).
- **Function Signature Verification:** Validates argument types and return values.
- **Scope Management:** Robust symbol table implementation for nested scopes.

## Architecture

The project is structured into three evolutionary phases, currently maintained as a monorepo to demonstrate the development lifecycle:

| Module | Description | Tech Stack |
| :--- | :--- | :--- |
| **Phase 1: Core Engine** | Lexer/Parser generation using ANTLR4, AST Construction, and Transpiler logic. | Java, ANTLR, Visitor Pattern |
| **Phase 2: Optimizer** | Symbol Table implementation (`NameAnalyzer`) and Code Optimization algorithms. | Java, Graph Theory |
| **Phase 3: Auditor** | Type Checking and Vulnerability Analysis (Memory Safety). | Java, Static Analysis |

## Project Structure

```bash
CPY-Compiler-Toolkit/
├── Phase-1/       # Core Parser & Transpiler Logic
├── Phase-2/       # Optimization & Symbol Table Modules
└── Phase-3/       # Final Version with Security & Type Checking
    └── last version/src/main/java/  # <--- Source of Truth for the latest build
Getting Started
Prerequisites
Java JDK 17 or higher

IntelliJ IDEA (Recommended) or any Java IDE

ANTLR4 Runtime

Installation & Run
Clone the repository:

Bash
git clone [https://github.com/Mostafa-Kermaninia/CPY-Compiler-Toolkit.git](https://github.com/Mostafa-Kermaninia/CPY-Compiler-Toolkit.git)
Navigate to the final phase source:

Bash
cd Phase-3/"last version"
Run the main compiler class. The input file should be a standard .c file.

Example Transformation
Input (Standard C):

C
int main() {
    int x = 10;
    if (x > 5) {
        printf("Hello");
    }
    return 0;
}
Output (CPY Transpiled):

Python
int main():
    int x = 10
    if x > 5:
        printf("Hello")
    end
    return 0
end
Contact
Mostafa Kermaninia Senior Full-Stack Engineer & Computer Engineering Student

GitHub Profile


---

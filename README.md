# Data Structures and Algorithms Practice

A collection of DSA problem solutions organized by topic, with detailed explanations and implementations in Java.

## Project Structure
```
├── problems/                    # All DSA problems organized by topic
│   ├── arrays/
│   │   └── product-except-self/
│   │       ├── ProductExceptSelf.java
│   │       ├── ProductExceptSelfTest.java
│   │       └── README.md
│   ├── strings/
│   ├── trees/
│   ├── graphs/
│   ├── linked-lists/
│   ├── stacks-queues/
│   ├── dynamic-programming/
│   ├── backtracking/
│   └── sorting-searching/
├── templates/                   # Templates for new problems
│   ├── Solution.java
│   ├── SolutionTest.java
│   └── README.md
├── scripts/                     # Utility scripts
└── pom.xml                     # Maven configuration
```

## Current Problems

### Arrays (1)
- **[Product of Array Except Self](problems/arrays/productexceptself/)** - O(n) solution without division

## Quick Start

### Build Project
```bash
mvn compile
```

### Run All Tests
```bash
mvn test
```

### Run Specific Problem
```bash
cd problems/arrays/productexceptself/
javac *.java
java ProductExceptSelfTest
```

## Adding New Problems

### Using Templates
1. **Use the script**: `./scripts/new-problem.sh arrays twosum TwoSum`
2. **Edit generated files** to implement your solution
3. **Update README.md** with problem details
4. **Add entry** to main README problems list

### Manual Setup
Each problem should follow this structure:
```
problems/[topic]/[problem-name]/
├── [ProblemName].java         # Solution class
├── [ProblemName]Test.java     # Test cases
└── README.md                  # Problem documentation
```

### Naming Conventions
- **Directories**: Use lowercase without hyphens (e.g., `twosum`, `productexceptself`)
- **Java Classes**: Use PascalCase (e.g., `TwoSum`, `ProductExceptSelf`)
- **Methods**: Use camelCase (e.g., `twoSum`, `productExceptSelf`)
- **Packages**: Follow directory structure (e.g., `arrays.twosum`, `trees.binarysearch`)

### Problem README Requirements
Each problem's README must include:
- **Problem Description**: Clear statement with examples
- **Constraints**: Input limitations and requirements
- **Solution Approach**: Algorithm explanation and key insights
- **Complexity Analysis**: Time and space complexity
- **Step-by-Step Example**: Detailed walkthrough
- **Running Instructions**: How to compile and test

## Development Guidelines

### Code Standards
- **Documentation**: Include JavaDoc for public methods
- **Complexity**: Document time and space complexity
- **Testing**: Provide comprehensive test cases including edge cases
- **Formatting**: Follow consistent Java coding conventions

### Maven Commands
```bash
# Compile all source files
mvn compile

# Run all tests
mvn test

# Clean build artifacts
mvn clean

# Generate project reports
mvn site
```

### Git Workflow
```bash
# After adding new problem
git add .
git commit -m "Add [Problem Name] solution with O(n) complexity"
git push origin main
```

## Templates Available

### 1. Solution Template (`templates/Solution.java`)
- Class structure with JavaDoc
- Method signature placeholders
- Complexity documentation

### 2. Test Template (`templates/SolutionTest.java`)
- Multiple test case structure
- Formatted output helpers
- Pass/fail validation

### 3. README Template (`templates/README.md`)
- Complete problem documentation structure
- Sections for all required information
- Consistent formatting

## Contributing

1. **Follow naming conventions** for consistency
2. **Use provided templates** for standardization
3. **Include comprehensive tests** with edge cases
4. **Document complexity** for all solutions
5. **Update main README** with new problem entries

## Problem Categories

- **Arrays**: Array manipulation, searching, sorting
- **Strings**: String processing, pattern matching
- **Trees**: Binary trees, BST, tree traversals
- **Graphs**: BFS, DFS, shortest paths
- **Linked Lists**: Manipulation, cycles, merging
- **Stacks/Queues**: Stack/queue operations, monotonic structures
- **Dynamic Programming**: Memoization, bottom-up solutions
- **Backtracking**: Constraint satisfaction, permutations
- **Sorting/Searching**: Various algorithms and optimizations
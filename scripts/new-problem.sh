#!/bin/bash

# Script to generate a new DSA problem from templates
# Usage: ./scripts/new-problem.sh <topic> <problem-name> <ClassName>
#
# Example: ./scripts/new-problem.sh arrays twosum TwoSum
# Note: problem-name should be valid Java package name (no hyphens)

set -e

# Check if correct number of arguments provided
if [ $# -ne 3 ]; then
    echo "Usage: $0 <topic> <problem-name> <ClassName>"
    echo "Example: $0 arrays two-sum TwoSum"
    echo ""
    echo "Available topics:"
    echo "  - arrays"
    echo "  - strings"
    echo "  - trees"
    echo "  - graphs"
    echo "  - linked-lists"
    echo "  - stacks-queues"
    echo "  - dynamic-programming"
    echo "  - backtracking"
    echo "  - sorting-searching"
    exit 1
fi

TOPIC=$1
PROBLEM_NAME=$2
CLASS_NAME=$3

# Validate topic
VALID_TOPICS=("arrays" "strings" "trees" "graphs" "linked-lists" "stacks-queues" "dynamic-programming" "backtracking" "sorting-searching")
if [[ ! " ${VALID_TOPICS[@]} " =~ " ${TOPIC} " ]]; then
    echo "Error: Invalid topic '$TOPIC'"
    echo "Valid topics: ${VALID_TOPICS[*]}"
    exit 1
fi

# Create problem directory
PROBLEM_DIR="problems/${TOPIC}/${PROBLEM_NAME}"
echo "Creating problem directory: $PROBLEM_DIR"
mkdir -p "$PROBLEM_DIR"

# Copy and customize templates
echo "Generating files from templates..."

# Solution file
cp templates/Solution.java "${PROBLEM_DIR}/${CLASS_NAME}.java"
sed -i '' "s/\[CLASS_NAME\]/${CLASS_NAME}/g" "${PROBLEM_DIR}/${CLASS_NAME}.java"
sed -i '' "s/\[TOPIC\]/${TOPIC}/g" "${PROBLEM_DIR}/${CLASS_NAME}.java"
sed -i '' "s/\[PROBLEM_PACKAGE\]/${PROBLEM_NAME}/g" "${PROBLEM_DIR}/${CLASS_NAME}.java"

# Test file
cp templates/SolutionTest.java "${PROBLEM_DIR}/${CLASS_NAME}Test.java"
sed -i '' "s/\[CLASS_NAME\]/${CLASS_NAME}/g" "${PROBLEM_DIR}/${CLASS_NAME}Test.java"
sed -i '' "s/\[TOPIC\]/${TOPIC}/g" "${PROBLEM_DIR}/${CLASS_NAME}Test.java"
sed -i '' "s/\[PROBLEM_PACKAGE\]/${PROBLEM_NAME}/g" "${PROBLEM_DIR}/${CLASS_NAME}Test.java"

# README file
cp templates/README.md "${PROBLEM_DIR}/README.md"
sed -i '' "s/\[CLASS_NAME\]/${CLASS_NAME}/g" "${PROBLEM_DIR}/README.md"

echo ""
echo "✅ Problem structure created successfully!"
echo ""
echo "📁 Files created:"
echo "   - ${PROBLEM_DIR}/${CLASS_NAME}.java"
echo "   - ${PROBLEM_DIR}/${CLASS_NAME}Test.java"
echo "   - ${PROBLEM_DIR}/README.md"
echo ""
echo "📝 Next steps:"
echo "   1. Edit ${CLASS_NAME}.java and implement your solution"
echo "   2. Update ${CLASS_NAME}Test.java with test cases"
echo "   3. Fill out README.md with problem details"
echo "   4. Add entry to main README.md"
echo ""
echo "🧪 Test your solution:"
echo "   cd ${PROBLEM_DIR}"
echo "   javac *.java"
echo "   java ${CLASS_NAME}Test"
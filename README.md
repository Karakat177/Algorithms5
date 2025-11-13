# Assignment 5 — String Analysis Using Knuth–Morris–Pratt (KMP) Algorithm
**Name:** Karakat  Ibraim
**Group:** se-2433

---

## 👩‍💻 Project Overview
This project implements the **Knuth–Morris–Pratt (KMP)** algorithm for substring search.  
KMP efficiently finds all occurrences of a pattern in a text in **linear time O(n + m)**, where _n_ is the text length and _m_ is the pattern length.

Project features:
- Separate input files for texts (`text_short.txt`, `text_medium.txt`, `text_long.txt`) and pattern (`pattern.txt`).
- Automatic printing of results and saving to `sample_outputs/outputs.txt`.
- Testing on **three text sizes**: short, medium, and long.
- Step-by-step comments in code for clarity.
- Analysis of algorithm complexity included.

---

## 📂 Project Structure
project/
├─ src/
│ ├─ Main.java 
│ └─ KMP.java
├─ data/
│ ├─ text_short.txt 
│ ├─ text_medium.txt 
│ ├─ text_long.txt 
│ └─ pattern.txt
├─ sample_outputs/
│ └─ outputs.txt
└─ README.md



---

## 📊 1. Test Summary
| Test File      | Text Length | Pattern Length | Occurrences | Positions |
|----------------|------------|----------------|------------|-----------|
| text_short.txt | 14         | 3              | 3          | [2, 5, 10] |
| text_medium.txt| 66         | 3              | 15         | [2, 5, 10, 14, 19, 22, 28, 31, 36, 40, 45, 48, 53, 56, 60] |
| text_long.txt  | 245        | 3              | 3          | [60, 140, 225] |

**Notes:**
- KMP correctly identifies all occurrences in all tests.
- Execution times are very fast, even for long texts.

---

## ⚙️ 2. Results (Per Test)
| Test File      | Occurrences | Execution Time (ms) |
|----------------|------------|-------------------|
| text_short.txt | 3          | 0.4283            |
| text_medium.txt| 15         | 0.0175            |
| text_long.txt  | 3          | 0.0589            |

---

## 🔍 3. Algorithm Analysis

**KMP Prefix Function (LPS array):**
- Time Complexity: **O(m)**
- Space Complexity: **O(m)**
- Purpose: allows the search to skip unnecessary comparisons on mismatch.

**KMP Search:**
- Time Complexity: **O(n)**
- Space Complexity: **O(k)** (for storing positions, k = number of matches)
- Overall Complexity: **O(n + m)** time, **O(m + k)** space.

**Observations:**
- Small texts: few comparisons, fast execution.
- Medium texts: more frequent pattern occurrences, still linear time.
- Long texts: linear scaling works well, execution remains efficient.

**Bottlenecks:**
- Very large patterns increase prefix function computation slightly.
- Number of matches affects space (storing positions).

---

## 📈 4. Performance Trends

| Observation                               | Explanation |
|-------------------------------------------|------------|
| Time grows linearly with text length      | Linear-time O(n + m) algorithm dominates runtime |
| Frequent matches increase position list   | Memory usage slightly higher for storing all positions |
| Shorter patterns increase matches         | More occurrences → more list entries, minor time impact |

---

## 🧠 5. Conclusions
- KMP reliably finds all pattern occurrences in texts of any length.
- Linear complexity ensures fast execution for large texts.
- Memory usage depends mainly on pattern length and number of matches.
- Suitable for automated text analysis and substring search in large datasets.

---

## 💾 6. Example Output (`sample_outputs/outputs.txt`)
--- text_short.txt ---
Text length: 14
Pattern length: 3
Occurrences: 3
Positions: [2, 5, 10]
Time: 0.4283 ms

--- text_medium.txt ---
Text length: 66
Pattern length: 3
Occurrences: 15
Positions: [2, 5, 10, 14, 19, 22, 28, 31, 36, 40, 45, 48, 53, 56, 60]
Time: 0.0175 ms

--- text_long.txt ---
Text length: 245
Pattern length: 3
Occurrences: 3
Positions: [60, 140, 225]
Time: 0.0589 ms

# HomeWork4
# Problem1
- This part's content is directly from the lecture, so I write it in java.

# Problem2
- The algorithm aims to find the smallest number of elements in an array whose sum exceeds a given target T.
- To achieve this efficiently, we apply a Greedy approach with a smooth incremental principle:
1. Sort the array in descending order.
   This ensures that larger elements are considered first, providing a “smooth and fast” increase toward the target.
2. Iteratively accumulate elements from largest to smallest.
   Each added element increases the sum in a controlled and stable way — the difference between consecutive additions is minimized.
3. Stop once the cumulative sum exceeds T.
   At that moment, the number of elements used is the minimal possible count.
   This approach ensures that the growth of the total sum is monotonic and smooth, minimizing fluctuations (i.e., avoiding too small or too large jumps).
   This “smoothness” helps the algorithm reach the threshold efficiently — similar to maintaining the shortest path to the goal in greedy optimization.

# Problem3
#  Right Triangle Counting Algorithm — Polar Angle Method

##  Implementation Overview
This program reads the coordinates, stores them as `Point` objects, and then counts all valid right triangles using an efficient **polar-coordinate + angle-difference** approach.  
It avoids expensive triple-nested loops and achieves **sub-quadratic time** in practice.

---

##  Heart of the Algorithm — Polar Angle & Angle Difference Method

###  Core Idea
For each point **P** (treated as a potential right-angle vertex):

1. **Compute the angle (direction)** from `P` to every other point using:
   ```java
   double angle = Math.atan2(dy, dx);
   ```
   This gives the **polar coordinate angle** (in radians) of the vector `(dx, dy)` relative to the x-axis.

2. **Sort** all these angles.

3. For every pair of direction angles `(θ₁, θ₂)` from `P`,  
   compute their absolute difference:
   ```java
   double diff = Math.abs(θ2 - θ1);
   ```

4. **Normalize the difference** so it always represents the smaller angle between the two vectors:
   ```java
"if (diff > Math.PI) diff = 2 * Math.PI - diff;"
   ```

5. If the difference is approximately equal to 90° (`π/2` radians),  
   we have found a right triangle with vertex `P`:
   ```java
   if (Math.abs(diff - RIGHT_ANGLE) < EPS) total++;
   ```

---

##  Why It Works
Two vectors form a right angle **if and only if** the angle between them is `π/2` radians (90°).  
By converting all other points around each vertex into **polar angles**,  
we reduce the geometric problem to a simple **angle difference check**.

This avoids heavy vector arithmetic (dot product) and eliminates the need for **triple loops**,  
so the algorithm runs efficiently even for large `n`.

---

##  Key Mathematical Concept
The **polar coordinate transformation** converts each vector `(dx, dy)` into an angle:

\[
\theta = \text{atan2}(dy, dx)
\]

Then, two vectors `A` and `B` form a right angle if:

\[
|\theta_A - \theta_B| \approx \frac{\pi}{2} \quad (\text{or } 90^\circ)
\]

---

##  Floating Point Precision
To handle floating-point rounding errors, we introduce:
```java
double EPS = 1e-9;
```
Angles that differ by less than `1e-9` are treated as equal —  
this defines a **tolerance margin** for floating-point comparison.

---

## Counting Adjustment
Each right triangle is counted **twice** (once for each right-angle vertex).  
Therefore, the final count must be divided by 2:


##  Key Constants
```java
double EPS = 1e-9;            // Floating-point tolerance (≈ 10⁻⁹)
double RIGHT_ANGLE = Math.PI / 2; // Constant representing 90° in radians
```

# Output

 Each right triangle is detected twice — once for each of its right-angle vertices.
 Divide by 2 to remove duplicate counts.
---

##  Time Complexity
| Step | Operation | Complexity |
|------|------------|-------------|
| For each of n points | Compute angles to other (n−1) points | O(n) |
| Sort the angles | O(n log n) |
| Compare all pairs | O(n²) (worst-case) |
| **Total** |  | **O(n²)** |

Efficient enough for **moderate input sizes** within ~30 seconds.

---

## Summary
| Concept | Description |
|----------|--------------|
| **Geometry Base** | Polar coordinates & angle difference |
| **Precision Control** | EPS tolerance for floating-point comparisons |
| **Optimization** | Avoids O(n³) brute force |
| **Result Adjustment** | Divide total by 2 due to duplicate counting |
| **Practical Performance** | Fast and stable for large datasets |
## 84. 柱状图中最大的矩形

https://leetcode-cn.com/problems/largest-rectangle-in-histogram/




```
class Solution1 {
    
    func largestRectangleArea(_ heights: [Int]) -> Int {
        // 枚举宽 双重循环
        var res = 0
        
        for left in 0..<heights.count {
            var height = Int.max
            for right in left..<heights.count {
                height = min(height, heights[right])
                let width = (right - left + 1)
                res = max(res, height * width)
            }
        }
        return res
    }
    
    
}

class Solution2 {
    
    func largestRectangleArea(_ heights: [Int]) -> Int {
        // 枚举高度 双重循环
        var res = 0
        
        for mid in 0..<heights.count {
            let height = heights[mid]
            var left = mid
            var right = mid
            //找到左侧高度比当前低的
            while left - 1 >= 0 && heights[left-1] >= height {
                left = left - 1
            }
            
            //找到右侧比当前高度低的
            while right + 1  < heights.count && heights[right+1] >= height {
                right = right + 1
            }
            //计算宽度
            let width = right - left + 1
            //计算面积
            
            res = max(res, width * height)
        }
        return res
    }
    
    
}

//单调栈
class Solution3 {
    
    func largestRectangleArea(_ heights: [Int]) -> Int {
        // 枚举宽 双重循环
        var res = 0
        var stack = [Int]()
        stack.append(-1)
        
        for mid in 0..<heights.count {
            while stack.last != -1 && stack.last! >= heights[mid] {
                let index = stack.removeLast()
                let width = mid - stack.last! - 1
                
                res = max(res, width * heights[index])
            }
            
            stack.append(mid)
            
        }
        
        while stack.last != -1 {
            let index = stack.removeLast()
            let width = index - stack.last! - 1
            
            res = max(res, width * heights[index])
        }
        
        return res
    }
    
    
}

//单调栈 一次循环
class Solution4 {
    
    func largestRectangleArea(_ heights: [Int]) -> Int {
        
        var res = 0
        
        var heights = heights
        //最后面添加一个元素0，作为哨兵，因为高度都大于等于0，都会进行计算面积
        heights.append(0)
        var stack = [Int]()
        
        for i in heights.indices {
            //这里的heights[stack.last!] >= heights[i]大于或者大于等于都可以
            //两个数相等，左右边界都是一样的
            //如果栈顶的值大于新入栈的值，需要计算面积高度并移除栈顶元素，因为已经找到了右边界
            while !stack.isEmpty && heights[stack.last!] >= heights[i] {
                //计算面积
                let h = heights[stack.removeLast()]
                let w = i - (stack.last ?? -1) - 1
                res = max(res, w * h)
            }
            //否则将 i 入栈
            stack.append(i)
        }
        //移除哨兵
        heights.removeLast()
        return res
    }
    
    
}
```

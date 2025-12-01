# Java Library Methods – String & Character

## 1. String Class Methods (`java.lang.String`)

### Length & Basic Info
- `length()` – Returns number of characters  
- `isEmpty()` – Checks if string is empty  
- `isBlank()` – Checks if string contains only whitespace  

### Character Access
- `charAt(index)` – Get character at index  
- `toCharArray()` – Convert string to char array  

### Comparison
- `equals()` – Case‑sensitive comparison  
- `equalsIgnoreCase()` – Case‑insensitive  
- `compareTo()` – Lexicographical compare  
- `compareToIgnoreCase()` – Case‑insensitive compare  

### Searching
- `contains(str)`  
- `indexOf(str)`  
- `lastIndexOf(str)`  
- `startsWith(prefix)`  
- `endsWith(suffix)`  

### Substring & Splitting
- `substring(begin)`  
- `substring(begin, end)`  
- `split(regex)`  
- `join(delimiter, elements...)`  

### Replace
- `replace(old, new)`  
- `replaceAll(regex, repl)`  
- `replaceFirst(regex, repl)`  

### Case Conversion
- `toUpperCase()`  
- `toLowerCase()`  

### Trim & Strip
- `trim()`  
- `strip()`  
- `stripLeading()`  
- `stripTrailing()`  

### Value Conversion
- `valueOf(data)`  
- `format(format, args)`  

---

## 2. StringBuilder / StringBuffer

- `append()`  
- `insert(index, value)`  
- `delete(start, end)`  
- `deleteCharAt(i)`  
- `replace(start,end,str)`  
- `reverse()`  
- `capacity()`  
- `ensureCapacity(x)`  

---

## 3. Character Class Methods (`java.lang.Character`)

### Checking Types
- `isDigit(ch)`  
- `isLetter(ch)`  
- `isLetterOrDigit(ch)`  
- `isWhitespace(ch)`  
- `isUpperCase(ch)`  
- `isLowerCase(ch)`  

### Conversion
- `toUpperCase(ch)`  
- `toLowerCase(ch)`  
- `getNumericValue(ch)`  

### Other
- `isAlphabetic(ch)`  
- `isSpaceChar(ch)`  
- `forDigit(num, radix)`  

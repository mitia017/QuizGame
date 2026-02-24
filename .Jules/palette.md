## 2024-05-24 - Shared Scanner for Java CLI Applications
**Learning:** In Java CLI applications, creating multiple `Scanner` instances wrapping `System.in` can lead to `NoSuchElementException`, especially when using piped input or redirects. This is because one `Scanner` may buffer more data than it currently needs, "consuming" input meant for the next `Scanner`.
**Action:** Use a single shared static `Scanner(System.in)` instance throughout the application to ensure consistent and reliable input handling.

package main

import (
	. "fmt"
)

/*
 입력 스트링을 10개씩 끊어서 출력
 */
func main() {
	var s string
	Scan(&s)
	l := len(s) / 10
	i := 0
	for ; i < l; i++ {
		Println(s[i * 10:(i + 1) * 10])
	}

	// print the remaining
	Println(s[i * 10:])
}

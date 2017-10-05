package main

import (
	"fmt"
	"bufio"
	"os"
	"strconv"
	"strings"
)

/*
 Sums the digits.
 */
func main() {
	reader := bufio.NewReader(os.Stdin)
	reader.ReadString('\n')  // ignore first input
	numString, _ := reader.ReadString('\n')

	// iterate through chars with trimmed string
	sum := 0
	for _, c := range strings.TrimSpace(numString) {
		num, _ := strconv.Atoi(string(c))  // convert to int
		sum += num
	}
	fmt.Println(sum)
}

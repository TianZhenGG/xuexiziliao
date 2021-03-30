package main

import (
	"fmt"
	"time"
)

func timestampDemo() {
	now := time.Now()
	timestamp2 := now.UnixNano()
	fmt.Printf("这是时间戳2：%v\n", timestamp2)
}

func main() {
	now := time.Now()
	fmt.Printf("current time:%v\n", now)
	year := now.Year()
	month := now.Month()
	day := now.Day()
	hour := now.Minute()
	minute := now.Minute()
	second := now.Second()
	fmt.Printf("这是时间%d-%02d-%02d %02d:%02d:%02d\n", year, month, day, hour, minute, second)

}

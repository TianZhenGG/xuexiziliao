package main

import (
	"fmt"
	"log"
	"os"
)

func demo() {
	logFile, err := os.OpenFile("./XX.log", os.O_CREATE|os.O_WRONLY|os.O_APPEND, 0644)
	if err != nil {
		fmt.Printf("open log file failed,err:", err)
	}
	log.SetOutput(logFile)
	log.SetFlags(log.Llongfile | log.Lmicroseconds | log.Ldate)
}

func main() {
	log.Panicln("这是一条普通日志")
	v := "很普通的"
	log.Printf("这是一条%s日志\n", v)
	log.Fatalln("这是一条会触发fatal的日志")
	log.Panicln("这是一条会触发panic的日志")
	log.SetFlags(log.Llongfile | log.Lmicroseconds | log.Ldate)
	log.Println("这是一条普通日志")

}

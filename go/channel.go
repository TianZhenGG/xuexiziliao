package channel


func worken(ch chan Task)  {
	for {
		//接受任务
		task := <- ch
		process(task)
	}
}


func main()  {
	//带缓冲channel
	ch := make(chan Task,3)
	for i := 0; i < numWorkers; i++ {
		go worker(ch)
	}
	//发送任务给worker
	helloTasks := getTasks()

	for _, task := range helloTasks {
		ch <- task
	}
}
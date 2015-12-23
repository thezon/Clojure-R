# function makes call to clojure-R webservice

clojure <- function (clojureCode){
	port<-3131
	server<-"localhost"
	param<-"cljin"
	print("Enter end or exit to stop Clojure processing.")
	repeat{
		clojureCode <- readline(prompt="clj> ")
		
		if(clojureCode == "end" || clojureCode == "exit"){
			break;
		}
		
		rin<-source(
			URLencode(
				paste("http://", server, ":", port, "/?", param,"=", clojureCode,sep="")))
		
		print(rin)
		}
	print("Clojure session has ended")
	}
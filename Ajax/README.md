## AJXA学习

### 第一章：原生AJAX

#### 1.1  AJAX简介

> 全称为Asynchronous Javascript And XML（异步JavaScript和XML）
>
> 不刷新页面的条件下，向服务端发送请求，即```无刷新获取数据``` 也是AJAX最大的优势！
>
> AJAX不是一门编程语言，而是一种将现有标准组合在一起使用的新方式。

##### AJAX优点

* 可以不刷新页面与服务器进行通信
* 允许根据用户事件来更新部分页面内容
* AJAX获得的数据被JS动态创建之后，这部分可以展示在网页，但信息不能被爬虫爬取

##### AJAX缺点 

* 没有浏览历史，不能回退
* 存在跨域问题（同源）

#### 1.2 XML简介

> XML：可扩展标记语言，被设计用来传输和存储数据，而HTML被设计用来呈现数据。
>
> 开始时AJAX就是使用XML格式进行数据交换，但```现已被JSON替换```

#### 1.3 node.js的安装

​		[2020 node.js的安装教程](https://blog.csdn.net/Small_Yogurt/article/details/104968169)

#### 1.4 AJAX发送GET请求

##### 1、AJAX的使用步骤：

1. 创建异步对象，即XMLHttpRequest对象；
2. 初始化，指定请求方法和请求url；
3. 发送请求；
4. 绑定onreadystatechange事件；
5. 确定服务器返回了所有对象后，处理返回结果；

##### 2、jsp页面代码

> 这里需要注意js文件的引入方式 src="${pageContext.request.contextPath}/js/weather.js" 
>
> 防止出现路径问题

```jsp
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--src="${pageContext.request.contextPath}/js/weather.js"--%>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/weather.js"></script>
<link rel="stylesheet" href="css/index.css">
<html>
<head>
    <title>AJAX GET请求</title>
</head>
<body>
<input type="text" id="search" name="search" placeholder="请输入要查询的内容">
<input type="button" id="btn" value="查询" onclick="Check()">
<br>
<div  id="result" ></div>
</body>
</html>
```

##### 3、js内容

> 请求URL的填写：
>
> “ / + 项目发布名 + / servlet映射名称 ”
>
> 
>
> GET请求参数设置：
>
> 在URL后用？分割然后加上要提交的变量和变量值



```js
function Check() {
    // alert("hello")
    const result = document.getElementById("result");
    //1.创建XHR对象
    const xhr = new XMLHttpRequest();
    //2.初始化，设定请求方法和请求url
    xhr.open("GET", "/test/server?search=hh");
    //3.发送
    xhr.send();
    //4.绑定事件，处理返回的结果
    xhr.onreadystatechange = function () {
        // 判断服务端返回了所有数据
        if (xhr.readyState === 4) {
            // 判断返回响应是否成功
            if (xhr.status === 200) {
                // 结果处理
                result.innerHTML = xhr.response;
            }
        }
    }
}
```

##### 4、servlet的配置

（这里制定了路径，所以不用配置xml配置文件

```java
@WebServlet("/server")
public class searchServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String search = request.getParameter("search");
        System.out.println(search + ":发来一条get请求");
        response.setContentType("text/html;charset=utf-8");
        response.getWriter().write("get请求已收到");
    }
}
```

###### 		@WebServlet的属性列表

​		<img src="F:\学习资料\学习笔记\images\@WebServlet的属性列表.png" style="zoom:95%;" />

#### 1.5 AJAX发送POST请求

##### 1、js内容

> 参数设置：
>
> 语法上参数设置比较的随意，只需要服务器端可以解析，就可以；
>
> send("a=100&b=100&c=100&d=100")或者send("hquwuifahfhoihqi")都可以传入服务器端
>
> 甚至可以自定义请求头的key和value（需要后端进行适配，否则会报错

```js
function post() {
    // alert("hello")
    const result = document.getElementById("result")
    //1.创建XHR对象
    const xhr = new XMLHttpRequest();
    //2.初始化，设定请求方法
    xhr.open("POST", "/test/server");
    //3.发送
    xhr.send();
    //xhr.send("a=100&b=100&c=100&d=100");
    //xhr.send("hquwuifahfhoihqi");
    
    //4.绑定事件，处理返回的结果
    xhr.onreadystatechange = function () {
        // 判断服务端返回了所有数据
        if (xhr.readyState === 4) {
            // 判断返回响应是否成功
            if (xhr.status === 200) {
                // 结果处理
                result.innerHTML = xhr.response;
            }
        }
    }
}
```

##### 2、servlet的配置（这里制定了路径，所以不用配置xml配置文件

```java
@WebServlet("/server")
public class searchServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("发来一条POST请求");
        response.setContentType("text/html;charset=utf-8");
        response.getWriter().write("POST请求已收到");
    }
}
```

#### 1.6  AJAX设置请求头信息

##### 1、HTTP请求头信息格式

```KEY：VALUE
KEY：VALUE
```

比如：
Contente-length:接下来的主体长度
Contente-type:接下来的主体类型

```js
// 设置请求头
xhr.setRequestHeader("Content-Type","application/x-www-form-urlencoded")
```

#### 1.7  AJAX处理接收到的json类型返回结果

##### 1、

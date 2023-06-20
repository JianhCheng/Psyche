# Psyche

[TOC]

## 1. 项目介绍

### 1.1 概述

​		基于计算机技术的发展和移动电子设备的普及，开发线上练习功能的题库管理系统显得格外重要。实现**文章推送**、**在线学习**、**刷题**等重要功能。是针对市场上尚不完善的心理学练习系统的补充，该系统是借助教育信息技术，实现便捷快速的线上教育的有效工具。

​		在此项目中，我们在前端部署框架，借用ElementUI来提高开发效率；使用Axios实现前后端通信；在后端部署Spring Boot框架、MyBatis-Plus，使用MySQL数据库存储数据；而此项目数据则是通过Scrapy框架进行网络爬取和定期更新获取的。

​		项目主要功能模块如下：

​		(1)用户端。用户可以进行个人账户的注册登录，在首页可以看到针对网站的基本介绍与使用方法。通过导航栏跳转到文章浏览、知识点学习或者题库练习。也可以进入个人主页转至收藏内容。

​		(2)后台管理系统。键入账号密码信息登录后，管理者可以查阅相关讯息，维护网站，查看和修正与网站相关的常规讯息，确保原始数据的准确性。



### 1.2 技术栈

前端：Vue+Vuex+Vue-router+ElementUI+Axios

后端：Spring Boot+Spring Security+MyBatis-Plus

数据库：MySQL

其他：Scrapy



## 2.功能模块介绍

### 2.1 用户端

#### 2.1.1登录/注册

​		用户在进入网站前会根据请求是否带有符合要求的token来判断是否登录，如果没有就会跳转到登录界面（除首页、、登录页、注册页外），登录成功后跳转到首页。

​		当用户输入密码，前端接收到输入的信息向后端发起请求，后端藉由Spring Security进行更为复杂的认证操作，由其判断用户账号密码和角色信息是否正确。若正确，后端会在响应中添加由系统生成的token并返回给前端。在登录成功后，前端保存用户的token并在之后的请求中将其加入请求头以保证正常的使用。页面效果如下所示：

 

![image-20230619211021862](https://github.com/JianhCheng/Psyche/blob/main/imgs/1.png)
								



​		由于很多新用户是没有账号在的，因此必须在登录页点击hasn`t account？跳到注册页面注册用户。用户只需输入账号密码及再次确认密码，无需其他信息，即可完成注册，避免了繁冗的信息填写所带来的困扰。其余信息登录后能在个人信息页面上补充填写。注册页面效果如图所示：

 

![image-20230619212707029](https://github.com/JianhCheng/Psyche/blob/main/imgs/2.png)
										



#### 2.1.2首页

​		首页是网站的总体介绍，根据网站已有的内容进行部署，有最新的期刊内容，也有更多的心理学文章。首页部分内容如图所示：

 

![image-20230619212718032](https://github.com/JianhCheng/Psyche/blob/main/imgs/3.png)
			

 

​		首页对网站内容进行了简单的介绍，能够让用户对网站信息有一定的了解，如下图所示。

 

![image-20230619212731208](https://github.com/JianhCheng/Psyche/blob/main/imgs/4.png)




#### 2.1.3文章模块

##### 2.1.3.1 文章展示

​		文章展示页会向用户展示最新的文章，可点击view more进入阅读，如下是最新文章的展示，效果如图：

![image-20230619214228252](https://github.com/JianhCheng/Psyche/blob/main/imgs/5.png)



 

​		如下，是推荐文章，点击标题可进入阅读，如图所示。

​														![image-20230619214922846](https://github.com/JianhCheng/Psyche/blob/main/imgs/6.png)


 

​		展示页还会展示阅读量、点赞、收藏最多的文章，点击标题可进入阅读。点击view more则进入文章列表页。 如图所示。

 

![image-20230619214243556](https://github.com/JianhCheng/Psyche/blob/main/imgs/7.png)




##### 2.1.3.2 文章列表

​		用户进入列表页后可以按照关键词搜索相应的文章，浏览页面上展示的内容，也可以根据右侧推荐进入阅读，效果图如下图所示：



 										![image-20230619215122185](https://github.com/JianhCheng/Psyche/blob/main/imgs/8.png)





##### 2.1.3.3 文章详情

​		 用户在选择喜欢的文章后进入阅读，可以了解到文章的详情信息，包括作者，关键词，出版时间，文章内容等，如下为该功能实现的部分代码，如果喜欢也可以实现点赞收藏等操作。如图：

 

![image-20230619215933153](https://github.com/JianhCheng/Psyche/blob/main/imgs/9.png)


 

​		在阅读完毕后，可在页面底部的Next模块继续阅读。如图：

 

![image-20230619215939530](https://github.com/JianhCheng/Psyche/blob/main/imgs/10.png)




#### 2.1.4 题库模块

##### 2.1.4.1 题库列表

​		题库板块在导航上可以点击跳转，系统会自动跳转至相应界面。在该界面，用户可以选择左侧的分类，以便查询不同类型的题库并根据自己的需求进行选择。同时，右侧会显示出相应的题库列表。如图所示：

 

![image-20230619215952433](https://github.com/JianhCheng/Psyche/blob/main/imgs/11.png)




##### 2.1.4.2 题库详情

​		用户在进入详情页后，会根据题目的结构分类，点击展开具体的题目.用户可以根据题目和题目考点来考量该题库是否适合自己，以及是否使用，如果觉得题库合适，同样可以进行收藏操作。点击题目即可从选择的题目开始刷题。效果如图所示：

 

![image-20230619220005188](https://github.com/JianhCheng/Psyche/blob/main/imgs/12.png)




##### 2.1.2.3 刷题

​		基于网站是为用户提供便携快捷的学习平台，刷题也只展示一题，在选择完/做完题目后提交，就会显示正确答案和相应解析。用户想继续刷题也可选择下一题继续。如图所示：



​													 ![image-20230619220238377](https://github.com/JianhCheng/Psyche/blob/main/imgs/13.png)



#### 2.1.5 知识点模块

##### 2.1.5.1 知识点列表

​		和题库列表页相似，用户可在知识点列表页选择合适的知识点进行学习。如图所示：

 

![image-20230619220254021](https://github.com/JianhCheng/Psyche/blob/main/imgs/14.png)




##### 2.1.5.2 知识点详情

​		进入知识点详情页，页面会展示相应的知识点和知识点内容，用户可自行了解学习，按需收藏，页面效果如图所示：

 

![image-20230619220303491](https://github.com/JianhCheng/Psyche/blob/main/imgs/15.png)




#### 2.1.6 个人主页

​		在个人主页，会展示用户的相关信息，用户可在页面内查看自己的收藏夹，自己的题库，完善个人主页。如图所示：

 

![image-20230619223548180](https://github.com/JianhCheng/Psyche/blob/main/imgs/16.png)


 

​		用户将鼠标放至按钮上则可展开选择支，点击选择支则可查看自己收藏的内容。有文章收藏，题库收藏，知识点收藏。页面效果如下图：

 

![image-20230619220431035](https://github.com/JianhCheng/Psyche/blob/main/imgs/17.png)




### 2.2管理员后台

#### 2.2.1登录

​		后台登录，管理者输入账户和密码，和题库系统的登录认证一般，前端会向后端发起请求，具体认证交由后端操作。当管理员提供的账号与密码与系统中记录的信息不匹配时，系统会根据不同情况返回相应的错误信息，即如果账号不存在则返回用户名不存在，如果密码不正确则返回密码不正确。登录成功后会，前端会将token存储以便后续的请求使用。如图所示：

 

![image-20230619220517197](https://github.com/JianhCheng/Psyche/blob/main/imgs/18.png)




#### 2.2.2功能管理

​		在功能管理分类里选择其下的子分支（如：文章管理、题库管理、知识点管理），可以获得相应的信息列表。数据库操作增删改查的基本操作是一定能够被实现的。同分支下其他的功能管理也是如此。如下，是题库管理的实现界面，效果如图所示：

 

![image-20230619220538440](https://github.com/JianhCheng/Psyche/blob/main/imgs/19.png)




#### 2.2.3系统管理

​		在选择系统管理这一分支时，会呈现对应的角色/用户管理。例如：用户管理功能可以添加、珊瑚用户，修改用户信息，改变用户权限等操作。并提供一系列操作按钮以方便管理。如下，是用户管理界面如下图所示：

 

![image-20230619220600598](https://github.com/JianhCheng/Psyche/blob/main/imgs/20.png)


 
















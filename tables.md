如何组织这些对象
1. 数据库设计：
 - words 表：存储单词信息。
 - sentences 表：存储句子信息。
 - word_sentence 表：存储单词和句子的关系。
2. 在Repository层：
 - 使用 DO 对象与数据库进行交互。
3. 在Service层：
 - 使用 BO 对象处理业务逻辑。
 - Service 方法接收 DTO 作为参数，并返回 DTO 或 VO。
4. 在Controller层：
 - 接收来自前端的 DTO，调用 Service 层的方法，并返回 VO 给前端。

概念
1. DO (Data Object)
   DO通常直接映射到数据库的表，因此通常会放在与数据库操作相关的包中。常见的命名为：

com.example.project.domain
com.example.project.entity
com.example.project.model
这些DO对象通常和数据库表有一一对应的关系。

2. DTO (Data Transfer Object)
   DTO用于在层之间传递数据，尤其是从服务层到控制层或网络边界外。因此，它们通常放在一个专门的传输对象包中。常见的命名为：

com.example.project.dto
com.example.project.transfer
DTO设计用来封装数据和隔离不同层之间的模型，避免直接依赖数据库实体模型。

3. VO (View Object)
   VO专门用于视图层，主要是为前端展示准备的数据格式。这些对象通常存放在视图相关的包中。常见的命名为：

com.example.project.vo
com.example.project.view
VO的设计通常基于用户界面的需求，包含用于显示的数据。

4. BO (Business Object)
   BO包含业务逻辑，它们是服务层的核心，处理具体的业务需求。BO一般位于业务逻辑层或模型层的包中。常见的命名为：

com.example.project.bo
com.example.project.business
com.example.project.service
BO的职责是封装业务规则，控制业务流程，通常不直接与数据库交互，而是通过调用DAO或Repository层与数据库交互


# DMReader
Android端代码由于代码版权，暂不公开
# 扫码出库系统（PC端）
## 功能
1. 用户登录
2. 订单列表和订单详情显示
3. 出库功能
## 技术栈
springBoot、Redis、MySQL
## 技术点：
1. 登录部分：加盐，两次MD5加密，Redis实现分布式Session，Redis用户缓存
2. 订单出库部分：Redis预出库减少数据库查询，Redis分布式锁
# APP端
## 流程图

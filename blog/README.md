# Blog Backend

个人博客后端项目，基于 Spring Boot 3、MyBatis-Plus、MySQL、Redis、Spring Security 和 JWT。

## 当前能力

- 后台登录：账号密码登录，返回 JWT。
- 后台鉴权：`/api/admin/**` 需要携带 `Authorization: Bearer <token>`。
- 前台公开接口：`/api/front/**` 无需登录。
- 内容模块：文章、分类、标签、站点配置、说说、相册、相册图片、友链、音乐、项目、关于、评论。
- 基础设施：统一返回、统一异常、分页、跨域、MyBatis-Plus 分页、逻辑删除。

## 目录说明

```text
src/main/java/com/boke/blog
├── common                      # 统一响应、错误码、分页对象
│   └── exception               # 业务异常和全局异常处理
├── config                      # Spring MVC、Security、MyBatis-Plus 配置
├── controller                  # 接口层
│   ├── admin                   # 后台管理接口
│   ├── auth                    # 登录接口
│   └── front                   # 前台公开接口
├── entity                      # 数据库实体类
├── mapper                      # MyBatis-Plus Mapper
├── security                    # JWT 过滤器和登录上下文
├── service                     # 业务接口
│   └── impl                    # 业务实现
├── util                        # 通用工具类
└── vo                          # 请求和响应对象
```

## 初始化数据库

执行：

```sql
src/main/resources/schema.sql
```

默认后台账号：

```text
username: admin
password: admin123
```

首次上线后请尽快修改默认密码。

## 常用接口

### 登录

```http
POST /api/auth/login
Content-Type: application/json

{
  "username": "admin",
  "password": "admin123"
}
```

### 前台公开接口

```text
GET /api/front/health
GET /api/front/site/config
GET /api/front/article/list
GET /api/front/article/{id}
GET /api/front/category/all
GET /api/front/tag/all
GET /api/front/talk/list
GET /api/front/album/list
GET /api/front/album/{albumId}/images
GET /api/front/friend/list
GET /api/front/music/list
GET /api/front/project/list
GET /api/front/about
GET /api/front/comment/article/{articleId}
POST /api/front/comment/add
```

### 后台管理接口

后台请求需要请求头：

```http
Authorization: Bearer <token>
```

```text
/api/admin/article
/api/admin/category
/api/admin/tag
/api/admin/site/config
/api/admin/talk
/api/admin/album
/api/admin/album/image
/api/admin/friend
/api/admin/music
/api/admin/project
/api/admin/about
/api/admin/comment
```

## 启动前检查

1. 确认本机 JDK 为 17 或以上。
2. 修改 `application.yaml` 中的 MySQL 和 Redis 配置。
3. 执行 `schema.sql` 创建数据库表。
4. 运行：

```bash
mvn -DskipTests compile
```

5. 启动项目后访问：

```text
http://localhost:8080/api/front/health
```

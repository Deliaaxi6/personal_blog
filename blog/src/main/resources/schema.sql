CREATE DATABASE IF NOT EXISTS blog_db DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
USE blog_db;


CREATE TABLE IF NOT EXISTS blog_user (
  id BIGINT PRIMARY KEY AUTO_INCREMENT,
  username VARCHAR(30) NOT NULL UNIQUE COMMENT '登录账号',
  password VARCHAR(100) NOT NULL COMMENT 'BCrypt密码',
  nickname VARCHAR(50) COMMENT '昵称',
  avatar VARCHAR(255) COMMENT '头像',
  intro TEXT COMMENT '简介',
  email VARCHAR(100),
  role VARCHAR(20) NOT NULL DEFAULT 'ADMIN' COMMENT '角色',
  status TINYINT NOT NULL DEFAULT 1 COMMENT '1启用 0禁用',
  create_time DATETIME DEFAULT CURRENT_TIMESTAMP,
  update_time DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);

INSERT INTO blog_user(username, password, nickname, role, status)
SELECT 'admin', '$2a$10$M262snjbPUmE8puyuyZXtOHVmBSzZPrtxdswbR64MZEF3kfqjxCKK', '管理员', 'ADMIN', 1
WHERE NOT EXISTS (SELECT 1 FROM blog_user WHERE username = 'admin');
CREATE TABLE IF NOT EXISTS category (
  id BIGINT PRIMARY KEY AUTO_INCREMENT,
  name VARCHAR(50) NOT NULL COMMENT '分类名称',
  sort INT DEFAULT 0 COMMENT '排序权重',
  create_time DATETIME DEFAULT CURRENT_TIMESTAMP,
  update_time DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);

CREATE TABLE IF NOT EXISTS tag (
  id BIGINT PRIMARY KEY AUTO_INCREMENT,
  name VARCHAR(30) NOT NULL UNIQUE COMMENT '标签名称',
  create_time DATETIME DEFAULT CURRENT_TIMESTAMP,
  update_time DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);

CREATE TABLE IF NOT EXISTS site_config (
  id BIGINT PRIMARY KEY AUTO_INCREMENT,
  config_key VARCHAR(50) NOT NULL UNIQUE COMMENT '配置键',
  config_value TEXT COMMENT '配置值',
  remark VARCHAR(100) COMMENT '配置说明',
  create_time DATETIME DEFAULT CURRENT_TIMESTAMP,
  update_time DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);

CREATE TABLE IF NOT EXISTS article (
  id BIGINT PRIMARY KEY AUTO_INCREMENT,
  title VARCHAR(100) NOT NULL COMMENT '文章标题',
  slug VARCHAR(120) UNIQUE COMMENT '固定链接',
  cover VARCHAR(255) COMMENT '封面图地址',
  summary VARCHAR(500) COMMENT '文章简介',
  content LONGTEXT NOT NULL COMMENT 'Markdown正文',
  category_id BIGINT COMMENT '分类ID',
  status TINYINT DEFAULT 0 COMMENT '0草稿 1发布',
  is_top TINYINT DEFAULT 0 COMMENT '是否置顶',
  is_recommend TINYINT DEFAULT 0 COMMENT '是否推荐',
  views INT DEFAULT 0 COMMENT '浏览量',
  seo_title VARCHAR(100),
  seo_description VARCHAR(255),
  publish_time DATETIME,
  create_time DATETIME DEFAULT CURRENT_TIMESTAMP,
  update_time DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  deleted TINYINT DEFAULT 0 COMMENT '逻辑删除',
  KEY idx_category_id (category_id),
  KEY idx_status_create_time (status, create_time),
  KEY idx_publish_time (publish_time)
);

CREATE TABLE IF NOT EXISTS talk (
  id BIGINT PRIMARY KEY AUTO_INCREMENT,
  content TEXT NOT NULL COMMENT '说说内容',
  images TEXT COMMENT '图片地址，多个用JSON数组存储',
  location VARCHAR(100) COMMENT '位置',
  status TINYINT DEFAULT 1 COMMENT '0隐藏 1公开',
  create_time DATETIME DEFAULT CURRENT_TIMESTAMP,
  update_time DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  deleted TINYINT DEFAULT 0,
  KEY idx_status_create_time (status, create_time)
);

CREATE TABLE IF NOT EXISTS album (
  id BIGINT PRIMARY KEY AUTO_INCREMENT,
  title VARCHAR(100) NOT NULL COMMENT '相册标题',
  description VARCHAR(500) COMMENT '相册描述',
  cover VARCHAR(255) COMMENT '封面图',
  sort INT DEFAULT 0,
  create_time DATETIME DEFAULT CURRENT_TIMESTAMP,
  update_time DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  deleted TINYINT DEFAULT 0
);

CREATE TABLE IF NOT EXISTS album_image (
  id BIGINT PRIMARY KEY AUTO_INCREMENT,
  album_id BIGINT NOT NULL COMMENT '相册ID',
  url VARCHAR(255) NOT NULL COMMENT '图片地址',
  caption VARCHAR(200) COMMENT '图片说明',
  sort INT DEFAULT 0,
  create_time DATETIME DEFAULT CURRENT_TIMESTAMP,
  update_time DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  KEY idx_album_id (album_id)
);

CREATE TABLE IF NOT EXISTS friend_link (
  id BIGINT PRIMARY KEY AUTO_INCREMENT,
  site_name VARCHAR(50) NOT NULL COMMENT '站点名称',
  site_url VARCHAR(255) NOT NULL COMMENT '站点地址',
  avatar VARCHAR(255) COMMENT '头像',
  description VARCHAR(200) COMMENT '描述',
  theme_color VARCHAR(50) COMMENT '主题色',
  sort INT DEFAULT 0,
  status TINYINT DEFAULT 1 COMMENT '0隐藏 1公开',
  create_time DATETIME DEFAULT CURRENT_TIMESTAMP,
  update_time DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  deleted TINYINT DEFAULT 0,
  KEY idx_status_sort (status, sort)
);

CREATE TABLE IF NOT EXISTS music (
  id BIGINT PRIMARY KEY AUTO_INCREMENT,
  song_name VARCHAR(100) NOT NULL COMMENT '歌曲名',
  artist VARCHAR(100) COMMENT '歌手',
  album VARCHAR(100) COMMENT '专辑',
  song_url VARCHAR(255) COMMENT '播放地址',
  cover VARCHAR(255) COMMENT '封面',
  duration INT COMMENT '时长秒',
  source_id VARCHAR(50) COMMENT '外部音乐ID',
  sort INT DEFAULT 0,
  status TINYINT DEFAULT 1 COMMENT '0隐藏 1公开',
  create_time DATETIME DEFAULT CURRENT_TIMESTAMP,
  update_time DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  deleted TINYINT DEFAULT 0
);

CREATE TABLE IF NOT EXISTS project (
  id BIGINT PRIMARY KEY AUTO_INCREMENT,
  name VARCHAR(100) NOT NULL COMMENT '项目名称',
  description VARCHAR(500) COMMENT '项目描述',
  icon VARCHAR(100) COMMENT '图标',
  github_url VARCHAR(255) COMMENT 'GitHub地址',
  demo_url VARCHAR(255) COMMENT '演示地址',
  tags VARCHAR(255) COMMENT '标签，多个用逗号或JSON数组存储',
  sort INT DEFAULT 0,
  status TINYINT DEFAULT 1 COMMENT '0隐藏 1公开',
  create_time DATETIME DEFAULT CURRENT_TIMESTAMP,
  update_time DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  deleted TINYINT DEFAULT 0
);

CREATE TABLE IF NOT EXISTS about (
  id BIGINT PRIMARY KEY,
  content LONGTEXT NOT NULL COMMENT '关于页面Markdown内容',
  update_time DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);

CREATE TABLE IF NOT EXISTS comment (
  id BIGINT PRIMARY KEY AUTO_INCREMENT,
  article_id BIGINT NOT NULL COMMENT '文章ID',
  parent_id BIGINT DEFAULT 0 COMMENT '父评论ID',
  nickname VARCHAR(30) NOT NULL COMMENT '昵称',
  email VARCHAR(100),
  website VARCHAR(255),
  content TEXT NOT NULL COMMENT '评论内容',
  status TINYINT DEFAULT 0 COMMENT '0待审核 1通过 2拒绝',
  ip VARCHAR(50),
  user_agent VARCHAR(255),
  create_time DATETIME DEFAULT CURRENT_TIMESTAMP,
  deleted TINYINT DEFAULT 0,
  KEY idx_article_id (article_id),
  KEY idx_parent_id (parent_id),
  KEY idx_status (status)
);

INSERT INTO site_config(config_key, config_value, remark)
SELECT 'blog_name', 'XingHuiSamaの宝藏之地', '博客标题'
WHERE NOT EXISTS (SELECT 1 FROM site_config WHERE config_key = 'blog_name');

INSERT INTO site_config(config_key, config_value, remark)
SELECT 'hero_name', 'XingHSama', 'Hero名称'
WHERE NOT EXISTS (SELECT 1 FROM site_config WHERE config_key = 'hero_name');

INSERT INTO site_config(config_key, config_value, remark)
SELECT 'hero_slogan', '在代码、学术与分子动力学模拟间穿梭的普通人。', 'Hero简介'
WHERE NOT EXISTS (SELECT 1 FROM site_config WHERE config_key = 'hero_slogan');

INSERT INTO about(id, content)
SELECT 1, '# 关于我\n\n这里写你的个人介绍。'
WHERE NOT EXISTS (SELECT 1 FROM about WHERE id = 1);




CREATE TABLE admin_info (
                            aId INT(16) PRIMARY KEY AUTO_INCREMENT COMMENT '管理员id号',
                            aName VARCHAR(64) unique NOT NULL  COMMENT '管理员用户名',
                            aPassword VARCHAR(64) NOT NULL  COMMENT '管理员密码',
                            aTelephone VARCHAR(64)  NOT NULL  COMMENT '管理员电话'
);

CREATE TABLE order_info (
                            oId INT(16) PRIMARY KEY AUTO_INCREMENT  COMMENT '订单id号',
                            totalMoney DOUBLE NOT NULL  COMMENT '订单总价格',
                            oState INT(16) NOT NULL  COMMENT '订单状态标识',
                            tableId VARCHAR(64) NOT NULL  COMMENT '订单桌台号',
                            pickupId VARCHAR(500) NOT NULL  COMMENT '订单取餐号',
                            orderTime TIMESTAMP NOT NULL  COMMENT '订单创建时间',
                            uid INT(16) NOT NULL  COMMENT '外键，订单所属用户id号'
);

CREATE TABLE goods_info (
                            gId INT(16) PRIMARY KEY AUTO_INCREMENT COMMENT '商品id号',
                            gName VARCHAR(500) unique NOT NULL  COMMENT '商品名称',
                            shopPrice DOUBLE NOT NULL  COMMENT '订单价格',
                            image VARCHAR(500) NOT NULL  COMMENT '商品图片',
                            g_desc VARCHAR(500) NOT NULL  COMMENT '商品描述',
                            g_number INT(16) NOT NULL  COMMENT '商品库存',
                            csid INT(16) NOT NULL  COMMENT '外键，关联二级商品类csid号',
                            saleNum INT(16) NOT NULL  COMMENT '商品销量',
                            gState INT(16) NOT NULL  COMMENT '标识是否有效，1商品有效，0商品无效',
                            gDate TIMESTAMP NOT NULL  COMMENT '商品添加时间'
);

CREATE TABLE user_info ( uid INT(16) PRIMARY KEY AUTO_INCREMENT COMMENT '用户id号',
                         username VARCHAR(64) unique NOT NULL  COMMENT '用户名',
                         password VARCHAR(64) NOT NULL  COMMENT '用户密码',
                         name VARCHAR(64) NOT NULL  COMMENT '用户姓名',
                         sex VARCHAR(16) NOT NULL  COMMENT '用户性别',
                         telephone VARCHAR(64)  NOT NULL  COMMENT '用户电话号码'
);

CREATE TABLE category_first (
                                cid INT(16) PRIMARY KEY AUTO_INCREMENT COMMENT '一级商品id号',
                                cname VARCHAR(64) unique NOT NULL  COMMENT '一级商品类名'
);

CREATE TABLE category_second (
                                 csid INT(16) PRIMARY KEY AUTO_INCREMENT COMMENT '二级商品类id号',
                                 csname VARCHAR(64) unique NOT NULL  COMMENT '二级商品类名',
                                 cid INT(16)   NOT NULL  COMMENT '外键，关联商品一级类别的cid号'
);

CREATE TABLE cart_info (
                           ctId INT(16) PRIMARY KEY AUTO_INCREMENT COMMENT '购物车id号',
                           uId INT(16) NOT NULL  COMMENT '外键，购物车属于用户id号',
                           gId INT(16) NOT NULL  COMMENT '外键，购物车所包含的商品id号',
                           gNum INT(16) NOT NULL  COMMENT '加入购物车的商品数目',
                           ctTime TIMESTAMP NOT NULL  COMMENT '商品加入购物车的时间',
                           specif VARCHAR(50) NOT NULL  COMMENT '商品加入购物车的规格（不辣，中辣，特辣）'
);


ALTER TABLE order_info ADD CONSTRAINT fk_order_info_uid FOREIGN KEY (uid) REFERENCES user_info(uid);

ALTER TABLE goods_info ADD CONSTRAINT fk_goods_info_csid FOREIGN KEY (csid) REFERENCES category_second(csid);

ALTER TABLE category_second ADD CONSTRAINT fk_category_second_cid FOREIGN KEY (cid) REFERENCES category_first(cid);

ALTER TABLE cart_info ADD CONSTRAINT fk_cart_info_uid FOREIGN KEY (uId) REFERENCES user_info(uid);
ALTER TABLE cart_info ADD CONSTRAINT fk_cart_info_gid FOREIGN KEY (gId) REFERENCES goods_info(gId);

121223
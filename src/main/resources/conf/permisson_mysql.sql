  --LOVESONG表结构设计(公司表 XC_COMPANYS、机构表：XC_ORGANIZATIONS、用户表 XC_USERS、用户组织关联表：XC_USERS_ORGS)
  ----------------------------------------------------------------------------------------------------
  -- Version History  :
  --   Revision      Modified_date       Reviser         Distription
  --   --------      -------------      ---------        --------------------
  --   V0.1          2012-7-02         Daniel Chen         Creation
  ----------------------------------------------------------------------------------------------------


-- 用户表 XC_USERS
create table XC_USERS (
	USER_ID bigint not null primary key AUTO_INCREMENT COMMENT '主键' ,    -- 主键
	USER_NAME varchar(75) null         COMMENT '登录账号' ,    -- 登录账号 *
	SCREEN_NAME varchar(75) null       COMMENT '昵称' ,    -- 昵称
	PASSWORD varchar(75) null          COMMENT '昵称' ,  	-- 昵称 *
	PASSWORD_ENCRYPTED tinyint         COMMENT '密码是否加密' ,    -- 密码是否加密
	PASSWORD_RESET tinyint             COMMENT '密码重置' ,    -- 密码重置
	PASSWORD_MODIFIED_DATE datetime null COMMENT '密码修改时间' ,   -- 密码修改时间
	SEX tinyint null                    COMMENT '性别' ,   -- 性别
	PHONE varchar(35) null				COMMENT '电话' ,	-- 电话
	FIXED_PHONE		varchar(35) null	COMMENT '固定电话' ,	-- 固定电话：
	BIRTHDAY datetime null             COMMENT '生日'  ,  	-- 生日
	EMAIL    varchar(75) null          COMMENT '邮件'  , 	-- 邮件 *
	ADDRESS varchar(150) null        	COMMENT '地址' ,	-- 地址
	COMPANY_ID bigint null             COMMENT 'FK ,公司表xc_company主键' ,    -- FK ,公司表xc_company主键
    COMMENTS longtext null             COMMENT '备注' ,    -- 备注
    PORTRAIT_URL varchar(150)          COMMENT '肖像链接地址' ,    -- 肖像链接地址
    GREET_WORD varchar(75) null        COMMENT '欢迎词' ,    -- 欢迎词
    
    LOGIN_COUNT int                    COMMENT '登录次数' ,   -- 登录次数
 	LOGIN_DATE datetime null           COMMENT '登录时间' ,   -- 登录时间
	LOGIN_IP varchar(75) null          COMMENT '登录IP'   , -- 登录IP
	LAST_LOGIN_DATE datetime null      COMMENT '最后一次登录时间' ,    -- 最后一次登录时间
	LAST_LOGIN_IP varchar(75) null     COMMENT '最后一次登录IP'   ,  -- 最后一次登录IP
	
  	ACTIVE tinyint      not null               COMMENT '是否有效' ,				-- 是否有效
	
  	DEL_FLAG TINYINT                NOT NULL DEFAULT '0' COMMENT '是否删除' ,  				-- 是否删除 *
  	CREATED_BY             bigint   not null   COMMENT '创建人'   ,  		-- 创建人
    CREATED_DATE            datetime not null   COMMENT '创建时间' ,    		-- 创建时间
    LAST_UPDATE_BY         bigint   not null   COMMENT '最后一次修改人'  ,   		-- 最后一次修改人
    LAST_UPDATE_DATE       datetime not null    COMMENT '最后一次修改时间'    		-- 最后一次修改时间
	
);

--用户账号表 xc_accounts
create table XC_ACCOUNTS (
	ACCOUNT_ID bigint not null primary key AUTO_INCREMENT COMMENT '主键' ,  -- 主键
	ACCOUNT_NAME varchar(75) null COMMENT '账号名称' ,          -- 账号名称
    ACCOUNT_TYPE varchar(75) null COMMENT '账号类型' ,           -- 账号类型
    PARENT_ACCOUNT_ID bigint COMMENT '父账号' ,                -- 父账号
    
    COMPANY_ID bigint null COMMENT 'FK，公司表xc_company主键' ,                        -- FK，公司表xc_company主键
	USER_NAME varchar(75) not null COMMENT '用户名称 ' ,               				-- 用户名称 *
    USER_ID bigint not null COMMENT 'FK, 用户表xc_users主键' ,                          -- FK, 用户表xc_users主键 *
	
	LEGAL_NAME varchar(75) null COMMENT '账号卡名称' ,              -- 账号卡名称
	LEGAL_CODE varchar(75) not null COMMENT '账号卡号码' ,              -- 账号卡号码*
	LEGAL_TYPE varchar(75) null COMMENT '账号卡类型' ,              -- 账号卡类型
		
	BALANCE DECIMAL null COMMENT '余额' ,                    -- 余额
	INTEGRAL int null COMMENT '积分' ,                      -- 积分
	CONSUME_NUM INT NOT NULL DEFAULT '3'  COMMENT '消耗指数' , 	 -- 消耗指数(这里默认为3)
	DEFAULT_FLAG int null  COMMENT '' , 					-- 是否是默认账户(1:默认;0:非默认)
  	ACTIVE tinyint                not null COMMENT '是否有效' ,  				-- 是否有效
	
  	DEL_FLAG TINYINT                NOT NULL DEFAULT '0' COMMENT '是否删除' ,  				-- 是否删除 *
  	CREATED_BY             bigint not null COMMENT '创建人' ,           		-- 创建人
    CREATED_DATE            datetime not null COMMENT '创建时间' ,        		-- 创建时间
    LAST_UPDATE_BY         bigint not null COMMENT '最后一次修改人' ,           		-- 最后一次修改人
    LAST_UPDATE_DATE       datetime not null   COMMENT '最后一次修改时间'        		-- 最后一次修改时间
);

--邮件内容表 XC_EMAIL_CONTEXTS
CREATE TABLE XC_EMAIL_CONTEXT (
	EMAIL_CONTEXT_ID BIGINT NOT NULL PRIMARY KEY AUTO_INCREMENT COMMENT '主键' ,  -- 主键 *
	EMAIL_ID	BIGINT NULL COMMENT 'FK,邮件表主键' ,          -- FK,邮件表主键,暂时不启用
	ACCOUNT_ID BIGINT NOT NULL  COMMENT 'FK,账号表主键' ,  -- FK,账号表主键 *
	USER_ID BIGINT NOT NULL  COMMENT 'FK,用户表主键' ,  -- FK,用户表主键 *
	TO_EMAIL    VARCHAR(75) NULL          COMMENT '接收人邮件'  , 	-- 接收人邮件 *
	EMAIL_SUBJECT	VARCHAR(75) NULL          COMMENT '邮件主题'  , 	-- 邮件主题
	EMAIL_CONTEXT VARCHAR(300) NOT NULL COMMENT '邮件内容' ,          -- 邮件内容 *
	GUESS_NUM TINYINT(3)  NOT NULL DEFAULT '3' COMMENT '允许猜次数' ,          -- 允许猜次数 *
	GUESS_STATUS TINYINT(3) UNSIGNED NOT NULL COMMENT '猜中状态 0:未查看 1: 己查看 2: 失败 3: 成功', -- 猜中状态 *
	SHOW_FLAG TINYINT(1) NOT NULL COMMENT '是否在表白墙展示', -- 否在表白墙展示
  
	COMMENTS LONGTEXT NULL             COMMENT '备注' ,    -- 备注
  	DEL_FLAG TINYINT                NOT NULL DEFAULT '0'  COMMENT '是否有效' ,  				-- 是否有效 *
	CREATED_BY             BIGINT NOT NULL COMMENT '创建人' ,           		-- 创建人
  	CREATED_DATE            DATETIME NOT NULL COMMENT '创建时间' ,        		-- 创建时间
  	LAST_UPDATE_BY         BIGINT NOT NULL COMMENT '最后一次修改人' ,           		-- 最后一次修改人
  	LAST_UPDATE_DATE       DATETIME NOT NULL   COMMENT '最后一次修改时间'        		-- 最后一次修改时间
);

--邀请表 XC_INVITE
CREATE TABLE XC_INVITES (
	INVITE_ID BIGINT NOT NULL PRIMARY KEY AUTO_INCREMENT COMMENT '主键' ,  -- 主键 *
	ACCOUNT_ID BIGINT NOT NULL  COMMENT 'FK,账号表主键' ,  -- FK,账号表主键 *
	USER_ID BIGINT NOT NULL  COMMENT 'FK,用户表主键' ,  -- FK,用户表主键 *
	PASSIVE_LEGAL_CODE varchar(75) NOT NULL  COMMENT '被邀请的账号卡号码' ,  -- 被邀请的账号卡号码 *
	INVITE_FLAG TINYINT NOT NULL COMMENT '邀请状态 1为成功 ,0为失败, 2为等待处理' , -- 邀请状态1为成功,0为失败,2为等待处理
	
  	DEL_FLAG TINYINT      NOT NULL DEFAULT '0' COMMENT '是否删除' ,  				-- 是否删除 *
	CREATED_BY             BIGINT NOT NULL COMMENT '创建人' ,           		-- 创建人
  	CREATED_DATE            DATETIME NOT NULL COMMENT '创建时间' ,        		-- 创建时间
  	LAST_UPDATE_BY         BIGINT NOT NULL COMMENT '最后一次修改人' ,           		-- 最后一次修改人
  	LAST_UPDATE_DATE       DATETIME NOT NULL   COMMENT '最后一次修改时间'        		-- 最后一次修改时间
);



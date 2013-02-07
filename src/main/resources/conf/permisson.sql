  --组织机构设计(公司表 XC_COMPANYS、机构表：XC_ORGANIZATIONS、用户表 XC_USERS、用户组织关联表：XC_USERS_ORGS)
  ----------------------------------------------------------------------------------------------------
  -- Version History  :
  --   Revision      Modified_date       Reviser         Distription
  --   --------      -------------      ---------        --------------------
  --   V0.1          2012-7-02         Daniel Chen         Creation
  ----------------------------------------------------------------------------------------------------

-- 公司表 XC_COMPANYS
create table XC_COMPANYS (
	COMPANY_ID bigint not null primary key,  	--主键
	NAME varchar(100) null,						--公司名称
	WEB_ID varchar(75) null,					--公司域名
	key_ longtext null,							--
	virtual_Host varchar(75) null,				--主机IP
	mx varchar(75) null,						--配置虚拟机参数
	LOGO_URL bigint								--首页Logo
);

--机构表：XC_ORGANIZATIONS
create table XC_ORGANIZATIONS (
	ORGANIZATION_ID bigint not null primary key,	--主键
	NAME varchar(100) null,							--组织名称
	COMPANY_ID bigint,								--FK,公司表xc_companys主键
	PARENT_ORGANIZATION_ID bigint,					--父组织ID
	ORDER_NUM int null,                         	--排序序号
	STATUS  varchar(15),							--状态
	COMMENTS longtext null,                			--备注
	
	EFFECTIVE_STATE_DATE datetime null,				--有效开始时间
  	EFFECTIVE_END_DATE   datetime null,				--有效结束时间
  	
  	ACTIVE tinyint,                    				--是否有效
	CREATED_BY             bigint,          		--创建人
    CREATE_DATE            datetime,        		--创建时间
    LAST_UPDATE_BY         bigint,          		--最后一次修改人
    LAST_UPDATE_DATE       datetime         		--最后一次修改时间
	
);
--用户组织关联表：XC_USERS_ORGS
create table XC_USERS_ORGS (
	USER_ID bigint not null,					--FK,用户表XC_USERS的主键
	ORGANIZATION_ID bigint not null,			--FK,组织表XC_ORGANIZATIONS的主键
	primary key (USER_ID, ORGANIZATION_ID)		--联合主键
);

-- 用户表 XC_USERS
create table XC_USERS (
	USER_ID bigint not null primary key,    --主键
	USER_NAME varchar(75) null,             --登录账号 *
	SCREEN_NAME varchar(75) null,           --昵称
	PASSWORD varchar(75) null,            	--密码 *
	PASSWORD_ENCRYPTED tinyint,             --密码是否加密
	PASSWORD_RESET tinyint,                 --密码重置
	PASSWORD_MODIFIED_DATE datetime null,   --密码修改时间
	SEX tinyint null,                       --性别
	PHONE varchar(35) null,					--电话
	FIXED_PHONE		varchar(35) null,		--固定电话：
	BIRTHDAY datetime null,                	--生日
	EMAIL    varchar(75) null,            	--邮件 *
	ADDRESS varchar(150) null,        		--地址
	COMPANY_ID bigint null,                 --FK ,公司表xc_company主键
    COMMENTS longtext null,                 --备注
    PORTRAIT_URL varchar(150),              --肖像链接地址
    GREET_WORD varchar(75) null,            --欢迎词
    
    LOGIN_COUNT int,                       --登录次数
 	LOGIN_DATE datetime null,              --登录时间
	LOGIN_IP varchar(75) null,             --登录IP
	LAST_LOGIN_DATE datetime null,          --最后一次登录时间
	LAST_LOGIN_IP varchar(75) null,         --最后一次登录IP
	
  	ACTIVE tinyint ,                    				--是否有效
	CREATED_BY             bigint,          		--创建人
    CREATE_DATE            datetime,        		--创建时间
    LAST_UPDATE_BY         bigint,          		--最后一次修改人
    LAST_UPDATE_DATE       datetime         		--最后一次修改时间
	
);

--用户账号表 xc_accounts
create table XC_ACCOUNTS (
	ACCOUNT_ID bigint not null primary key , --主键
	ACCOUNT_NAME varchar(75) null,          --账号名称
    ACCOUNT_TYPE varchar(75) null,          --账号类型
    PARENT_ACCOUNT_ID bigint,               --父账号
    
    COMPANY_ID bigint,                       --FK，公司表xc_company主键
	USER_NAME varchar(75) null,              --用户名称 *
    USER_ID bigint,                          --FK, 用户表xc_users主键 *
	
	LEGAL_NAME varchar(75) null,             --账号卡名称
	LEGAL_CODE varchar(75) null,             --账号卡号码
	LEGAL_TYPE varchar(75) null,             --账号卡类型
		
	BALANCE DECIMAL null,                   --余额
	INTEGRAL int null,                      --积分
	CONSUME_NUM INT NOT NULL DEFAULT '3' ,	 --消耗指数(这里默认为3)
	DEFAULT_FLAG int null ,					--是否是默认账户(1:默认;0:非默认)
  	ACTIVE tinyint,                    				--是否有效
	CREATED_BY             bigint,          		--创建人
    CREATE_DATE            datetime,        		--创建时间
    LAST_UPDATE_BY         bigint,          		--最后一次修改人
    LAST_UPDATE_DATE       datetime         		--最后一次修改时间
);




--一种是公共的（Public），还有一种是私有的（Private）。通常情况下，
--公共的页面是没有控制浏览权限的，也就是说所有人都可以看的。而私有页面则一定要登录，并且有相应的权限才能浏览
--社区默认的只有Guest社区，供非注册用户访问
--前台web/home后台 admin/home
--

  --权限设计(资源表 XC_RESOURCES、角色表：XC_ROLES、角色资源表 XC_ROLES_RESOURCES、用户角色关联表 XC_USERS_ROLES)
  ----------------------------------------------------------------------------------------------------
  -- Version History  :
  --   Revision      Modified_date       Reviser         Distription
  --   --------      -------------      ---------        --------------------
  --   V0.1          2012-7-02         Daniel Chen         Creation
  ----------------------------------------------------------------------------------------------------

--1：资源表 XC_RESOURCES
create table XC_RESOURCES (
	RESOURCE_ID bigint not null primary key,   --主键
	RESOURCE_CODE varchar(50) null,            --资源码
	RESOURCE_NAME varchar(100) null,           --资源名称
	RESOURCE_URL varchar(150) null,            --资源链接
    RESOURCE_TYPE int null,					   --资源类型
	TARGET varchar(50) null,                   --资源链接类型
    
    LEVEL_NUM int null,                        --资源级别
	ORDER_NUM int null,                         --序号
    ALIASES varchar(50) null,                  --别名
	STYLE varchar(250) null,                   --资源样式
	UNI_ID  varchar(200) null,                 --唯一标示
	
    COMMENTS varchar(250) null,           --备注
	PARENT_RES_ID bigint null,              --父资源ID
		
  	ACTIVE tinyint,                    				--是否有效
	CREATED_BY             bigint,          		--创建人
    CREATE_DATE            datetime,        		--创建时间
    LAST_UPDATE_BY         bigint,          		--最后一次修改人
    LAST_UPDATE_DATE       datetime         		--最后一次修改时间
);

--2: 权限表 XC_PERMISSIONS 
--考虑到功能权限可以看做是一种资源,故合并到资源表中,用字段RESOURCE_TYPE 标示
--create table XC_PERMISSIONS (
--	PERMISSION_ID bigint not null primary key,
--	COMPANY_ID bigint,
--	RESOURCE_ID bigint
--);


--3: 角色表：XC_ROLES
create table XC_ROLES (
	ROLE_ID bigint not null primary key,	--主键
	ROLE_NAME varchar(75) null,				--角色名称		
	ROLE_TYPE integer null,					--角色类型
	COMMENTS longtext null,           		--备注
	
  	ACTIVE tinyint,                    				--是否有效
	CREATED_BY             bigint,          		--创建人
    CREATE_DATE            datetime,        		--创建时间
    LAST_UPDATE_BY         bigint,          		--最后一次修改人
    LAST_UPDATE_DATE       datetime         		--最后一次修改时间
	
);

--4: 角色资源表 XC_ROLES_RESOURCES
create table XC_ROLES_RESOURCES (
	ROLE_ID bigint not null,			--FK,角色表xc_roles的主键
	RESOURCE_ID bigint not null,		--FK,资源表xc_resources的主键
	ACTIVE_ tinyint,                    --是否有效
	primary key (role_id, resource_id)	--联合主键
);


--5：用户角色关联表 XC_USERS_ROLES
create table USERS_ROLES (
	USER_ID bigint not null,			--FK,用户表xc_users的主键
	ROLE_ID bigint not null,			--FK,角色表xc_roles的主键
	
	ACTIVE_ tinyint,                    --是否有效
	primary key (user_Id, role_id)
);
--用户组表 XC_USERGROUPS
create table XC_USERGROUPS (
	USERGROUP_ID bigint not null primary key,		--主键	
	NAME varchar(75) null,							--用户组名称
	COMMENTS longtext null,           				--备注
	COMPANY_ID bigint,								--FK,公司表XC_COMPANYS的主键
	PARENT_USERGROUP_ID bigint,						--父用户组的ID
	
  	ACTIVE tinyint,                    				--是否有效
	CREATED_BY             bigint,          		--创建人
    CREATE_DATE            datetime,        		--创建时间
    LAST_UPDATE_BY         bigint,          		--最后一次修改人
    LAST_UPDATE_DATE       datetime         		--最后一次修改时间
);
--用户用户组关联表：XC_USERS_USERGROUPS
create table XC_USERS_USERGROUPS (
	user_Id bigint not null,				--FK,用户表XC_USERS的主键
	userGroup_Id bigint not null,			--FK,用户组XC_USERGROUPS的主键
	primary key (user_Id, userGroup_Id)		--联合主键
);
--角色和用户组的关联表 XC_GROUPS_ROLES
create table XC_GROUPS_ROLES (
	GROUP_ID bigint not null,	--FK,用户组表主键
	ROLE_ID bigint not null,	--FK,角色表主键
	primary key (GROUP_ID, ROLE_ID)
);


--bga_role_resource = 权限表
--bga_role = 权限表
--dbo.bga_user_role = 角色权限关联表
--bga_user_profile = 用户角色表

--社区表：XC_GROUPS  
create table XC_GROUPS (
	GROUP_ID bigint not null primary key, 		--主键
	NAME varchar(75) null,						--组织名称
	COMMENTS longtext null,           			--备注
	GROUP_TYPE varchar(75) null,				--组织类型
	COMPANY_ID bigint,							--FK,公司表xc_companys主键
	PARENT_GROUP_ID bigint,						--父组织ID
	
  	ACTIVE tinyint,                    				--是否有效
	CREATED_BY             bigint,          		--创建人
    CREATE_DATE            datetime,        		--创建时间
    LAST_UPDATE_BY         bigint,          		--最后一次修改人
    LAST_UPDATE_DATE       datetime         		--最后一次修改时间
);
--组织社区关联表：XC_GROUPS_ORGS
create table XC_GROUPS_ORGS (
	GROUP_ID bigint not null,
	ORGANIZATION_ID bigint not null,
	primary key (GROUP_ID, ORGANIZATION_ID)
);


  --邮件设计(邮件用户信息字段 xc_mail_users、邮件组 XC_MAIL_EMAILGROUPS、用户用户组关联表：XC_MAIL_USERS_mailGROUPS
  --		、邮件服务器配置表 xc_mail_profiles、邮件信息表 ：xc_mail_messages)
  ----------------------------------------------------------------------------------------------------
  -- Version History  :
  --   Revision      Modified_date       Reviser         Distription
  --   --------      -------------      ---------        --------------------
  --   V0.1          2012-7-03         Daniel Chen         Creation
  ----------------------------------------------------------------------------------------------------
--1：邮件用户信息字段 xc_mail_users
create table XC_MAIL_USERS (

	SCREEN_NAME varchar(75) null,           --昵称 *
	EMAIL    varchar(75) null,            	--邮件 *
	PHONE varchar(35) null,					--电话
	FIXED_PHONE		varchar(35) null,		--固定电话：  
	
	SEX tinyint null,                       --性别
	BIRTHDAY datetime null,                	--生日
	ADDRESS varchar(150) null,        		--地址
	COMPANY varchar(150) null,              --公司
	COMMENTS longtext null,                	--备注 
	
	BACK_MAIL	varchar(75) null,            	--备用邮件
	COMMUNICATION_SN	varchar(35) null,		--通信号码,例如QQ,MSN
	ANNIVERSARY datetime,          				--纪念日
	
	ACTIVE tinyint,                    				--是否有效
	CREATED_BY             bigint,          		--创建人
	CREATE_DATE            datetime,        		--创建时间
	LAST_UPDATE_BY         bigint,          		--最后一次修改人
	LAST_UPDATE_DATE       datetime         		--最后一次修改时间
);
--2:邮件组 XC_MAIL_EMAILGROUPS
--系统新增加的邮件挂在默认的邮件组DEFAULT_EMAILGROUP
create table XC_MAIL_EMAILGROUPS (
	MAILGROUP_ID bigint not null primary key,		--主键	
	NAME varchar(75) null,							--邮件组名称 *
	COMMENTS longtext null,           				--备注
	PARENT_USERGROUP_ID bigint,						--父邮件组的ID
	
  	ACTIVE tinyint,                    				--是否有效
	CREATED_BY             bigint,          		--创建人
    CREATE_DATE            datetime,        		--创建时间
    LAST_UPDATE_BY         bigint,          		--最后一次修改人
    LAST_UPDATE_DATE       datetime         		--最后一次修改时间
);

--3: 用户用户组关联表：XC_MAIL_USERS_mailGROUPS
create table XC_MAIL_USERS_USERGROUPS (
	EMAIL varchar(75) not null,				--邮件
	MAILGROUP_ID bigint not null,			--FK,邮件组XC_MAIL_EMAILGROUPS的主键
	primary key (EMAIL, MAILGROUP_ID)		--联合主键
);
--4: 邮件服务器配置表 xc_mail_profiles
create table xc_mail_profiles (
	ID bigint not null primary key,		--主键	
	EMAIL_HOST 	varchar(75) null,		--邮件服务器
	EMAIL_USERNAME 	varchar(75) null,	--用户名
	EMAIL_PASSWORD	varchar(75) null,	--用户密码
	EMAIL_TO		longtext null,		--接收人
	EMAIL_FROM		varchar(75) null,	--发送人
	EMAIL_SMTP_AUTH	int null,			--是否需要服务器进行认证用户名和密码是否正确
	EMAIL_ENCODING	varchar(15) null,	--编码设置
	EMAIL_SMTP_TIMEOUT	int null,		--超时时间设定
	EMAIL_SMTP_STARTTLS					--
	EMAIL_SMTP_SOCKETFACTORY_CLASS		--
	EMAIL_DEFAULT	tinyint null,		--是否默认
	
	USER_NAME varchar(75) null,         --登录账号 *
	
  	ACTIVE tinyint,                    				--是否有效
	CREATED_BY             bigint,          		--创建人
    CREATE_DATE            datetime,        		--创建时间
    LAST_UPDATE_BY         bigint,          		--最后一次修改人
    LAST_UPDATE_DATE       datetime         		--最后一次修改时间
);
--5：邮件信息表 ：xc_mail_messages
create table xc_mail_messages (
	ID bigint not null primary key,				--主键
	EMAIL_TO	longtext null,					--接收人
	EMAIL_FROM	varchar(75) null,				--发送人
	EMAIL_CC	longtext null,					--抄送人
	EMAIL_BCC	longtext null,					--暗送人
	EMAIL_Subject varchar(250) null,			--主题
	EMAIL_Text	longtext null,					--内容
	EMAIL_ImgFile varchar(250) null,			--图片链接
	EMAIL_AttachmentFile	varchar(250) null,	--附件链接
	EMAIL_PROFILE	varchar(250) null,			--来源那个服务器
	MAIL_STATUS		tinyint null,				--邮件状态
	MAIL_TYPE	bigint null,					--邮件类型
	
	ACTIVE tinyint,                    				--是否有效
	CREATED_BY             bigint,          		--创建人
    CREATE_DATE            datetime,        		--创建时间
    LAST_UPDATE_BY         bigint,          		--最后一次修改人
    LAST_UPDATE_DATE       datetime         		--最后一次修改时间
);

--5：爬虫信息表 ：xc_crawler_messages
CREATE TABLE XC_CRAWLER_MESSAGES (
	ID BIGINT NOT NULL PRIMARY KEY,				-- 主键
	TITLE	VARCHAR(450) NOT NULL,				-- 商品标题
	SITEURL	VARCHAR(450) NOT NULL,				-- 商品链接
	IMAGE	VARCHAR(450) NOT NULL,				-- 商品图片
	QUANTITY	INT NULL,						-- 商品数量
	PRICE DOUBLE NULL,							-- 定价
	BARGINPRICE	DOUBLE NULL,					-- 促销价
	STANDARD VARCHAR(120) NULL,					-- 规格
	EFFICACY	VARCHAR(250) NULL,				-- 功效
	SUITABLE	VARCHAR(120) NULL,				-- 适用人群
	STARTTIME		DATETIME NULL,				-- 开始时间
	ENDTIME	DATETIME NULL,						-- 结束时间
	TRYNUM	INT NULL,							-- 申请人数
	DESCRIPTION	VARCHAR(750) NULL,				-- 描述
	REMARK		VARCHAR(750) NULL,				-- 备注
	MERCHANT	VARCHAR(150) NULL,				-- 商家
	WEBSITE	VARCHAR(150) NULL,					-- 来源网站
	CITY		VARCHAR(150) NULL,				-- 城市
	PRIORITY	INT NULL,						-- 优先级
	TAGS	VARCHAR(150) NULL,					-- 商品标签
	AUTO	INT NULL,							-- 是否自动抓取(0:否;1:是)
	EFFECTIVE		INT NULL,					-- 是否有效(0:无效;1:有效)
	
	ACTIVE TINYINT,                    				-- 是否有效
	CREATED_BY             BIGINT,          		-- 创建人
    CREATE_DATE            DATETIME,        		-- 创建时间
    LAST_UPDATE_BY         BIGINT,          		-- 最后一次修改人
    LAST_UPDATE_DATE       DATETIME         		-- 最后一次修改时间
);



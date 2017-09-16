package com.gospell.drm.drmman;


public interface Constants
{
    public static final int		DVB_VERSION							= 10033;
	public static final String	IS_UPDATE_PROGRAM					= "isForUpdateProgram";
	public static final String	B_SHORTCUT_ENTER					= "b_shortcut_enter";

	//信号类型
	public static final byte	 TUNER_SIG_TYPE_SAT					= 1;
	public static final byte	 TUNER_SIG_TYPE_DVB_T				= 2;
	public static final byte	 TUNER_SIG_TYPE_DVB_T2				= 3;
	public static final byte	 TUNER_SIG_TYPE_ISDB_T				= 4;
	
	//
	public static final int		HOST_PORT							= 8181;
	public static final int		DB_MAX_SATELLITE_NAME_LEN			= 30;
	public static final int		MAX_SERVICE_NAME_LEN				= 32;
	public static final int		DVBS_MAX_SERVICE_NAME_LEN			= 32;
	public static final int		kCS_EIT_MAX_EVENT_NAME_LENGTH		= 64;
	public static final int		kCS_EIT_MAX_SHORT_DESC_LENGTH		= 256;
	public static final int		kCS_EIT_MAX_EXTENDED_DESC_LENGTH	= 2048;
	public static final int		SCROLL_OSD_MAX_LEN					= 400;
	
	//前端广告系统设置参数时参考的分辨率的大小常量
	public static final int		AD_STANDARD_SCREEN_WIDTH			= 720;	
	public static final int		AD_STANDARD_SCREEN_HEIGHT			= 576;
	
	//biss
	public static final int		BISS_KEY_MAX_LEN					= 8;								//biss key的长度值
	
	// 天线控制
	public static final int		FE_DISEQC_STORE_POSITION			= 10;								
	public static final int		FE_DISEQC_GOTO_POSITION				= 11;								
	public static final int		FE_DISEQC_LIMIT						= 12;								
	public static final int		FE_DISEQC_MOVE						= 13;								
	public static final int		FE_DISEQC_STOP						= 14;								
	public static final int		FE_DISEQC_GOTO_ANGULAR				= 17;

	/** diseqc type constant **/
	public static final int		DISEQC_NONE							= 0;
	public static final int		DISEQC_1_0							= 1;
	public static final int		DISEQC_1_1							= 2;
	public static final int		DISEQC_1_2							= 3;
	public static final int		DISEQC_1_3							= 4;

	// 字符集
	public static final int		SYS_CHARSET_UNDEFINED				= 0x00;							// !<// Unknown character set.
	public static final int		SYS_CHARSET_ISO8859_1				= 0x01;							// !<ISO/IEC-8859-1
	public static final int		SYS_CHARSET_ISO8859_2				= 0x02;							// !<ISO/IEC-8859-2
	public static final int		SYS_CHARSET_ISO8859_3				= 0x03;							// !<ISO/IEC-8859-3
	public static final int		SYS_CHARSET_ISO8859_4				= 0x04;							// !<ISO/IEC-8859-4
	public static final int		SYS_CHARSET_ISO8859_5				= 0x05;							// !<ISO/IEC-8859-5 (Fig.A.2)
	public static final int		SYS_CHARSET_ISO8859_6				= 0x06;							// !<ISO/IEC-8859-6 (Fig.A.3)
	public static final int		SYS_CHARSET_ISO8859_7				= 0x07;							// !<ISO/IEC-8859-7 (Fig.A.4)
	public static final int		SYS_CHARSET_ISO8859_8				= 0x08;							// !<ISO/IEC-8859-8 (Fig.A.5)
	public static final int		SYS_CHARSET_ISO8859_9				= 0x09;							// !<ISO/IEC-8859-9 (Fig.A.6)
	public static final int		SYS_CHARSET_ISO8859_10				= 0x0A;							// !<ISO/IEC-8859-10(Fig.A.7)
	public static final int		SYS_CHARSET_ISO8859_11				= 0x0B;							// !<ISO/IEC-8859-11(Fig.A.8)
	public static final int		SYS_CHARSET_ISO8859_12				= 0x0C;							// !<Reserved for Indian
	public static final int		SYS_CHARSET_ISO8859_13				= 0x0D;							// !<ISO/IEC-8859-13(Fig.A.9)
	public static final int		SYS_CHARSET_ISO8859_14				= 0x0E;							// !<ISO/IEC-8859-14(Fig.A.10)
	public static final int		SYS_CHARSET_ISO8859_15				= 0x1F;							// !<ISO/IEC-8859-15(Fig.A.11)
	public static final int		SYS_CHARSET_TABLE0					= 0x10;							// !<ISO/IEC-6937 + Euro Symb.(Fig. A.1)
	public static final int		SYS_CHARSET_ISO_10646				= 0x11;							// !<ISO/IEC 10646-1(16 Bit)
	public static final int		SYS_CHARSET_UTF8					= 0x12;							// !<UTF-8 encoding of ISO/IEC 10646-1
	public static final int		SYS_CHARSET_UNICODE					= 0x13;							// !<Unicode
	public static final int		SYS_CHARSET_GB2312					= 0x14;							// !<Unicode
	
	//节目相关
	public static final int 	PROGRAM_INVALUE_INDEX				= 0xFFFF;
	
	//Gospell CA相关
	public static final int		GOSCA_FORCE_SERVICE_ID_MAX			= 10;								// 最多支持的显示Service ID个数
	public static final int		GOSCA_FORSE_FINGER_CONTENT_MAX_LEN	= 128;
	public static final int		GOSCA_MAXNUM_COMPONENT				= 5;								//强制换台中节目组件的最大个数
	public static final int		GOSCA_MAXLEN_LOCKMESS				= 40;								//强制换台中保留参数的最大长度
	public static final int		GOSCA_COMPONENT_RESERVER_MAXLEN		= 3;								//强制换台中节目组件预留参数的最大长度
	public static final int		GOSCA_FORCE_FINGER_SET_TRANSPARENTS_MAXCOUNT		= 2;				//强制裸眼指纹设置透明度的最大计数(由于裸眼指纹设置很低的透明度，肉眼无法看到，为了方便测试验证，刚接受到裸眼指纹先不设置透明度，大概1秒后设置透明度)
	
	/* 服务端发送过来的消息的消息类型常量 */
	public static final int		MESSAGE_TYPE_TUNER					= 0;
	public static final int		MESSAGE_TYPE_CA						= MESSAGE_TYPE_TUNER + 1;
	public static final int		MESSAGE_TYPE_NIT					= MESSAGE_TYPE_CA + 1;
	public static final int		MESSAGE_TYPE_OTA					= MESSAGE_TYPE_NIT + 1;
	public static final int		MESSAGE_TYPE_GOSAD					= MESSAGE_TYPE_OTA + 1;			// 广告信息

	/* 邮件信息常量 */
	public static final byte	GOSCAS_EMAIL_NEW					= 0;							// 新邮件通知 
	public static final byte	GOSCAS_EMAIL_NEW_NO_ROOM			= 1;							// 有新邮件 ， 但Email空间不够
	public static final byte	GOSCAS_EMAIL_NONE					= (byte) 255;					// 隐藏标志 (即0xff)
																										 
	/* 插入智能卡，智能卡相关的状态常量 */
	public static final byte	CA_CARD_OUT							= 0;							/*智能卡未插入状态*/
	public static final byte	CA_CARD_IN							= 1;							/*智能卡插入状态*/
	public static final byte	GOS_CARD_STATUS_INACTIVE			= 3;							/* 未激活状态 ,当卡插反时 ，卡将处于未激活状态 */

	/* 子母卡配对过程常量 */
	public static final byte	PARE_STB_INSERT_MASTER				= 0;
	public static final byte	PARE_STB_INSERT_SLAVE				= PARE_STB_INSERT_MASTER + 1;
	public static final byte	PARE_CARD_OVER						= PARE_STB_INSERT_SLAVE + 1;
	
	// 子母卡配对错误信息
	public static final int		GOSCAERR_BASE_STB					= 0xF1000000;					// 机顶盒返回值基值定义
	public static final int		GOSCAPAIR_GETOPERATION_ERROR		= (GOSCAERR_BASE_STB + 30);		// 获取运营商发卡信息出错，可能卡没有接受到发卡信息或卡通信错误
	public static final int		GOSCAPAIR_SMART_TYPE_ERROR			= (GOSCAERR_BASE_STB + 31);		// 所插入的卡和需要操作的流程不匹配，如流程中要求插入子卡而实际检测插入的不是子卡
	public static final int		GOSCAPAIR_SMART_GETMASTERINF_ERROR	= (GOSCAERR_BASE_STB + 32);		// 获取主卡（母卡）配对信息操作失败！
	public static final int		GOSCAPAIR_SMART_GETSLAVEINF_ERROR	= (GOSCAERR_BASE_STB + 33);		// 获取从卡（子卡）配对信息操作失败！
	public static final int		GOSCAPAIR_SMART_NOPAREID_ERROR		= (GOSCAERR_BASE_STB + 34);		// 主从卡配对号不一致！
	public static final int		GOSCAPAIR_MSPARE_FAILURE_ERROR		= (GOSCAERR_BASE_STB + 35);		// 主从卡配操作失败！
	public static final int		GOSCAPAIR_PROCESS_TYPE_ERROR		= (GOSCAERR_BASE_STB + 36);		// 操作流程步骤不合法！

	// 函数返回结果的相关常量
	public static final int		GOS_SUCCESS							= 0;
	public static final int		GOS_FAILURE							= -1;
	
	/************************* Activity properties *********************************/
	public static final int		INVALID_MSG_CONTENT_ID				= -1;
	public static final int		PROGRAM_NOT_EXIST_SHOW_TIME			= 20;							
	public static final int		INTERVAL							= 100;
	public static final int		PRO_NUM_INPUT_DELAY_TIME			= 10;								
	public static final int		SHOW_TIME							= 25;
	public static final int		INVALID_TIME						= -1;
	public static final int		PRO_DETAIL_INFO_SHOW_TIME			= 6000;					// 频道信息显示的时间为6s
	public static final int		PER_PAGE_PRO_NUM					= 10;					// 节目列表中列表一次显示的节目数量
	public static final int		DEL_NUM								= 99999999;
	public static final int		SAT_CHANNEL_LIST					= 4;
	public static final int		INVAL_NUMBER						= 1024 * 1024;
	public static final int		TIMER_PERIOD						= 200;
	public static final int		TIMER_OSD_PERIOD					= 10;
	public static final int		DESKTOP_SHOW_TIMER					= 5000 / TIMER_PERIOD;
	public static final int		PLAYER_SERVICE_LOCK_TIME			= 1600;
	public static final int		DESKTOP_EPG_CHECK_TIME				= 4000 / TIMER_PERIOD;

	/*------------------CA相关消息常量---------------------------------------------*/
	public static final int		CA_CARD_IN_MSG						= 0;
	public static final int		CA_CARD_OUT_MSG						= CA_CARD_IN_MSG + 1;
	public static final int		CA_EMAIL_MSG						= CA_CARD_OUT_MSG + 1;
	public static final int		CA_FINGER_MSG						= CA_EMAIL_MSG + 1;
	public static final int		CA_OSD_MSG							= CA_FINGER_MSG + 1;
	public static final int		CA_PROMPT_MSG						= CA_OSD_MSG + 1;
	public static final int		CA_FORCE_OSD_MSG					= CA_PROMPT_MSG + 1;
	public static final int		CA_FORCE_FINGER_MSG					= CA_FORCE_OSD_MSG + 1;
	public static final int		CA_DRIVER_MSG						= CA_FORCE_FINGER_MSG + 1;
	public static final int		CA_TOKENS_MSG						= CA_DRIVER_MSG + 1;
	public static final int		CA_MATURITY_MSG						= CA_TOKENS_MSG + 1;
	public static final int		CA_FORCELOCKSERVICE_MSG				= CA_MATURITY_MSG + 1;			// 强制换台
	public static final int		NIT_FORCE_SRCH_MSG					= CA_FORCELOCKSERVICE_MSG + 1;	// 强制搜索
	public static final int		NIT_ASK_SRCH_MSG					= NIT_FORCE_SRCH_MSG + 1;		// 询问客户是否搜索
	public static final int		NIT_REMIND_SRCH_MSG					= NIT_ASK_SRCH_MSG + 1;			// 弹出提示框，但不能选择，几秒钟之后直接搜索
	public static final int		OTA_FORCE_UPD_MSG					= NIT_REMIND_SRCH_MSG + 1;		// 强制升级
	public static final int		OTA_ASK_UPD_MSG						= OTA_FORCE_UPD_MSG + 1;		// 询问客户是否升级
	public static final int		OTA_REMIND_SRCH_MSG					= OTA_ASK_UPD_MSG + 1;			// 弹出提示框，但不能选择，几秒钟之后直接升级
	public static final String	NIT_OTA_TYPE						= "nit_ota_type";
	public static final String	NIT_OTA_PROMPT_TYPE					= "nit_ota_prompt_type";
	public static final int		GOSCA_ENTITLE_PID_LENGTH			= 5;							// 授权信息产品包号长度
	public static final int		GOSCA_ENTITLE_STIME_LENGTH			= 20;							// 授权信息开始时间长度
	public static final int		GOSCA_ENTITLE_ETIME_LENGTH			= 20;							// 授权信息结束时间长度
	
	// logo图片类型
	public static final byte	LOGO_MENU_IMAGE						= 0;							// 对应菜单图片
	public static final byte	LOGO_WATER_MARK_IMAGE				= 1;							// 对应水印图片
	public static final byte	LOGO_RADIO_BG_IMAGE					= 2;							// 对应广播背景图片

	//广告图片类型
	public static final byte	GOSAD_ROLL_IMAGE					= 0;							// 对应滚动广告图片
	public static final byte	GOSAD_POSITION_IMAGE				= 1;							// 对应挂角广告图片
	public static final byte	GOSAD_CHANNEL_IMAGE					= 2;							// 对应换台广告图片
	public static final byte	GOSAD_RADIO_IMAGE					= 3;							// 对应广播广告图片
	public static final byte	GOSAD_MENU_IMAGE					= 4;							// 对应菜单广告图片
	public static final byte	GOSAD_LOGO_IMAGE					= 5;							// 对应开机广告图片
	
	// stream type(要获取的流类型常量)
	public static final byte	STREAM_TYPE_AUDIO					= 0;
	public static final byte	STREAM_TYPE_SUB						= 1;
	public static final byte	STREAM_TYPE_TTX						= 2;

	//高斯贝尔区域控制智能卡类型常量
	public static final byte	AREACTL_SMART_COMM					= 0;
	public static final byte	AREACTL_SMART_INIT					= 1;
	public static final byte	AREACTL_SMART_CLEAR					= 2;
	
	//高斯贝尔机卡绑定变量取值常量
	public static final byte	GOS_STB_BIND_SUPPORT				= 1;
	public static final int 	GOS_STB_BIND_CARDINFO_MAXLEN		= 64;
	public static final int 	GOS_STB_BIND_STBINFO_MAXLEN			= 64;
	public static final int		INVALUE_BINDCARD_SERIAL				= 0xFFFFFFFF;
	public static final int		INVALUE_BINDSTB_SERIAL				= 0xFFFFFFFF;
	public static final int 	GOS_STB_BIND_MAXNUMBER				= 5;
	
	public static final byte	REC_TYPE_NORMAL						= 0;			//正常的录制
	public static final byte	REC_TYPE_TIME_SHIFT					= 1;			//时移录制

	public static final byte	MAX_FAVORITE_GROUNP_NUMBER			= 8;
	//多画面中某一窗口的背景绘制类型
	public static final byte 	DRAW_TYPE_AD						= 0;			//绘制广告背景图片
	public static final byte 	DRAW_TYPE_LOCK						= 1;			//绘制加密背景图片
	
	//是否是由于有升级提示信息进入的手动升级界面（即ManualUpgradeActivity中）的标志的key
	public static final String UPGRADE_MANUAL_FLAG = "upgrade_flag";
	
	//处理太和升级消息相关常量
	public static final String LOADER_UPGRADE_TYPE = "upgrade type";
	public static final byte LOADER_ASK_UPGRADE 	= 0;
	public static final byte LOADER_FORCE_UPGRADE 	= 1; 

	public static final int	    CONAX_PASSWORD_MAXLENGTH			= 4;			//CONAX CA最大密码长度
	public static final int	    SYSTEM_FIRSTINIT					= 1;			//系统首次初始化
	public static final int	    SYSTEM_12HOUR_TYPE					= 0;			//系统首次初始化
	public static final int	    SYSTEM_24HOUR_TYPE					= 1;			//系统首次初始化
	/**
	 * 通过Handler类的handleMessage处理的消息常量类接口
	 */
	public static interface HandleMsg
	{
		int	MSG_HIDE_INFO_PANEL					= 0;
		int	MSG_HANDLE_INPUT_NUMBER				= MSG_HIDE_INFO_PANEL + 1;
		int	MSG_GET_EPG_NOWNEXT					= MSG_HANDLE_INPUT_NUMBER + 1;
		int	MSG_SHOW_MESSAGE					= MSG_GET_EPG_NOWNEXT + 1;			// 消息提示框显示
		int	MSG_HIDE_MESSAGE					= MSG_SHOW_MESSAGE + 1;						// 消息提示框隐藏标志
		int	OSD_MSG_SHOW						= MSG_HIDE_MESSAGE + 1;
		int	OSD_MSG_HIDE						= OSD_MSG_SHOW + 1;
		int	EMAIL_MSG_ICON_SHOW					= OSD_MSG_HIDE + 1;					// email图标显示标志
		int	EMAIL_MSG_ICON_HIDE					= EMAIL_MSG_ICON_SHOW + 1;			// email图标隐藏标志
		int	EMAIL_MSG_PROMPT_SHOW				= EMAIL_MSG_ICON_HIDE + 1;			// 有新email消息，但空间不够消息框显示标志
		int	EMAIL_MSG_PROMPT_HIDE				= EMAIL_MSG_PROMPT_SHOW + 1;		// 有新email消息，但空间不够消息框隐藏标志
		int	FINGER_MSG_SHOW						= EMAIL_MSG_PROMPT_HIDE + 1;		// 显示指纹信息的常量
		int	FINGER_MSG_HIDE						= FINGER_MSG_SHOW + 1;
		int	MSG_PVR_EVENT_HANDLE				= FINGER_MSG_HIDE + 1;
		int	MSG_NIT_CHANGED						= MSG_PVR_EVENT_HANDLE + 1;
		int	MSG_CUR_EVENT_CAN_NOT_PLAY			= MSG_NIT_CHANGED + 1;
		int	MSG_CHANGE_PRO_SIGNAL_INFO			= MSG_CUR_EVENT_CAN_NOT_PLAY + 1;
		int	MSG_HIDE_PRO_DETAIL_INFO			= MSG_CHANGE_PRO_SIGNAL_INFO + 1;
		int	MSG_UPGRADE_SOFTWARE				= MSG_HIDE_PRO_DETAIL_INFO + 1;
		
		/*----------------------------广告消息---------------------------------*/
		int	MSG_GOS_AD_ROLL_PICTURE_INFOR		= MSG_UPGRADE_SOFTWARE + 1;
		int	MSG_GOS_AD_POSITION_PICTURE_INFOR	= MSG_GOS_AD_ROLL_PICTURE_INFOR + 1;
		int	MSG_GOS_AD_CHANNEL_PICTURE_INFOR	= MSG_GOS_AD_POSITION_PICTURE_INFOR + 1;
		int	MSG_GOS_AD_RADIO_PICTURE_INFOR		= MSG_GOS_AD_CHANNEL_PICTURE_INFOR + 1;
		int	MSG_GOS_AD_MENU_PICTURE_INFOR		= MSG_GOS_AD_RADIO_PICTURE_INFOR + 1;
		int	MSG_GOS_AD_LOGO_PICTURE_INFOR		= MSG_GOS_AD_MENU_PICTURE_INFOR + 1;
		int	MSG_GOS_AD_POSITION_PICTURE_HIDE	= MSG_GOS_AD_LOGO_PICTURE_INFOR + 1;//挂角广告时间结束消息
		/*----------------------------各CA可能共同用到的消息---------------------------------*/
		int	MSG_CARD_IN							= MSG_GOS_AD_POSITION_PICTURE_HIDE + 1;
		int	MSG_CARD_OUT						= MSG_CARD_IN + 1;
		/*----------------------------Gos CA相关---------------------------------------*/
		int	MSG_GOS_PRO_EMAIL					= MSG_CARD_OUT + 1;					// 处理GOSCA卡的邮件的消息
		int	MSG_GOS_SHOW_FINGER					= MSG_GOS_PRO_EMAIL + 1;			// 显示GOSCA卡的指纹消息
		int	MSG_GOS_HIDE_FINGER					= MSG_GOS_SHOW_FINGER + 1;			// 隐藏GOSCA卡的指纹消息
		int	MSG_GOS_SHOW_OSD					= MSG_GOS_HIDE_FINGER + 1;			// 显示osd消息
		int	MSG_GOS_HIDE_OSD					= MSG_GOS_SHOW_OSD + 1;				// 隐藏osd消息
		int	MSG_GOS_SHOW_FORCE_OSD				= MSG_GOS_HIDE_OSD + 1;				// 显示 force osd消息
		int	MSG_GOS_HIDE_FORCE_OSD				= MSG_GOS_SHOW_FORCE_OSD + 1;		// 隐藏forcd osd消息
		int MSG_GOS_SHOW_FORCE_FINGER			= MSG_GOS_HIDE_FORCE_OSD + 1;		//显示强制指纹
		int MSG_GOS_HIDE_FORCE_FINGER			= MSG_GOS_SHOW_FORCE_FINGER + 1;	//隐藏强制指纹
		int	MSG_GOS_SHOW_PROMPT					= MSG_GOS_HIDE_FORCE_FINGER + 1;	// 显示prompt消息
		int	MSG_GOS_HIDE_PROMPT					= MSG_GOS_SHOW_PROMPT + 1;			// 隐藏prompt消息
		int	MSG_GOS_FORCE_FINGER_TRANSPARENT	= MSG_GOS_HIDE_PROMPT + 1;			// 隐藏prompt消息
		/*----------------------------Grif CA 相关------------------------------------*/
		int	MSG_GRIF_SHOW_CARD_STATUS			= MSG_GOS_FORCE_FINGER_TRANSPARENT + 1;
		int	MSG_GRIF_SHOW_MATE_RATE				= MSG_GRIF_SHOW_CARD_STATUS + 1;	// 显示节目的级别
		int	MSG_GRIF_HIDE_MATE_RATE				= MSG_GRIF_SHOW_MATE_RATE + 1;		// 隐藏节目的级别
		int	MSG_GRIF_SHOW_IPPV					= MSG_GRIF_HIDE_MATE_RATE + 1;		// 显示IPPV信息
		int	MSG_GRIF_SHOW_OSD_MESSAGE			= MSG_GRIF_SHOW_IPPV + 1;			// 显示OSD消息
		int	MSG_GRIF_HIDE_OSD_MESSAGE			= MSG_GRIF_SHOW_OSD_MESSAGE + 1;	// 隐藏OSD消息
		int	MSG_GRIF_SHOW_PROMPT				= MSG_GRIF_SHOW_IPPV + 1;			// 显示CA卡的提示消息
		int	MSG_GRIF_HIDE_PROMPT				= MSG_GRIF_SHOW_PROMPT + 1;			// 隐藏CA卡的提示消息
		/*----------------------------Taihe CA相关------------------------------------*/
		int	MSG_TAIHE_SHOW_EMAIL				= MSG_GRIF_HIDE_PROMPT + 1;			// 显示Taihe
		int	MSG_TAIHE_PRO_FINGER				= MSG_TAIHE_SHOW_EMAIL + 1;			// 显示Taihe
		int	MSG_TAIHE_SHOW_OSD_MSG				= MSG_TAIHE_PRO_FINGER + 1;			// 处理Taihe
		int	MSG_TAIHE_HIDE_OSD_MSG				= MSG_TAIHE_SHOW_OSD_MSG + 1;		// 隐藏osd信息框的消息
		int	MSG_TAIHE_SHOW_IPPV					= MSG_TAIHE_HIDE_OSD_MSG + 1;		// 显示Taihe
		int	MSG_TAIHE_SHOW_PPT					= MSG_TAIHE_SHOW_IPPV + 1;			// 显示Taihe
		int	MSG_TAIHE_SHOW_SERVICE				= MSG_TAIHE_SHOW_PPT + 1;			// 显示Taihe
		int	MSG_TAIHE_SHOW_LOADER				= MSG_TAIHE_SHOW_SERVICE + 1;		// 显示Taihe
		/*----------------------------Conax CA相关------------------------------------*/
		int	MSG_CNX_SHOW_DRIVER					= MSG_TAIHE_SHOW_LOADER + 1;		// 显示CNXCA卡的driver信息
		int	MSG_CNX_HIDE_DRIVER					= MSG_CNX_SHOW_DRIVER + 1;			// 隐藏CNXCA卡的driver信息
		int	MSG_CNX_SHOW_EMAIL					= MSG_CNX_HIDE_DRIVER + 1;			// 显示CNXCA卡的email信息
		int	MSG_CNX_HIDE_EMAIL					= MSG_CNX_SHOW_EMAIL + 1;			// 隐藏CNXCA卡的email信息
		int	MSG_CNX_SHOW_FINGER					= MSG_CNX_HIDE_EMAIL + 1;			// 显示CNXCA卡的finger id
		int	MSG_CNX_HIDE_FINGER					= MSG_CNX_SHOW_FINGER + 1;			// 隐藏CNXCA卡的finger id
		int	MSG_CNX_SHOW_OSD					= MSG_CNX_HIDE_FINGER + 1;			// 隐藏CNXCA卡的finger id
		int	MSG_CNX_HIDE_OSD					= MSG_CNX_SHOW_OSD + 1;				// 隐藏CNXCA卡的finger id
		int	MSG_CNX_SHOW_PROMPT					= MSG_CNX_HIDE_OSD + 1;				// 显示CNXCA卡的prompt信息
		int	MSG_CNX_HIDE_PROMPT					= MSG_CNX_SHOW_PROMPT + 1;			// 隐藏CNXCA卡的prompt信息
		int	MSG_CNX_SHOW_TOKENS					= MSG_CNX_HIDE_PROMPT + 1;			// 显示tokens
		int	MSG_CNX_HIDE_TOKENS					= MSG_CNX_SHOW_TOKENS + 1;			// 隐藏tokens
		int	MSG_CNX_SHOW_MATURITY				= MSG_CNX_HIDE_TOKENS + 1;			// 显示节目的父母锁级别
		int	MSG_CNX_HIDE_MATURITY				= MSG_CNX_SHOW_MATURITY + 1;		// 隐藏节目的父母锁级别
		int	MSG_CHECK_SCHEDULE_EVENT			= MSG_CNX_HIDE_MATURITY+1;			//检测定时观看录制事件的消息
		int	MSG_START_SCHEDULE_EVENT			= MSG_CHECK_SCHEDULE_EVENT+1;		//开始执行定时观看或录制事件
		int	MSG_END_SCHEDULE_EVENT				= MSG_START_SCHEDULE_EVENT+1;		//结束定时录制事件
		int	MSG_SHOW_SCHEDULE_VIEW_PROMPT		= MSG_END_SCHEDULE_EVENT+1;			//显示即将执行定时观看事件的提示
		int	MSG_SHOW_SCHEDULE_REC_PROMPT		= MSG_SHOW_SCHEDULE_VIEW_PROMPT+1;	//显示即将执行定时录制事件的提示
		int	MSG_DRAW_ONE_VIDEO_BACKGROUND		= MSG_SHOW_SCHEDULE_REC_PROMPT+1;	//绘制多画面中某一画面的背景图
		
		//Parent control
		int	MSG_PARENT_CONTROL					= MSG_DRAW_ONE_VIDEO_BACKGROUND+1;	//父母锁消息
	}
	
	/**
	 *Gospell CA提示信息常量接口
	 */
	public static interface GosCAPromptInfo
	{
		byte GOSCA_No_OSDPromt					= 0;							/* 无OSD提示 */
		byte GOSCA_SMART_STOP					= 1;							/* 卡已被禁用 */
		byte GOSCA_SMART_AREA_NOPAIR			= 2;							/* 流卡区域不匹配 */
		byte GOSCA_SMART_IPPT_SWITCH			= 3;							/* IPPT用户提示 */
		byte GOSCA_SMART_STB_NOPAIR				= 4;							/* 机卡不配对 */
		byte GOSCA_SMART_PROG_NOENTITLE			= 5;							/* 节目类未授权 */
		byte GOSCA_SMART_PROG_NOENTITLE_IPPT	= 6;							/* 节目类未授权 */
		byte GOSCA_SMART_MOTHER_SON_PAIR		= 7;							/* 子母卡需重新配对 */
		byte GOSCA_SMART_MOTHER_SON_TIMEOUT		= 8;							/* 子母卡配对超时 */
		byte GOSCA_SMART_PAIR_OK				= 10;							/* 机卡对应OK */
		byte GOSCA_SMART_LAST_DAY				= 11;							/* 最后提示天数 */
		byte GOSCA_SMART_AREA_LOCK				= 0x10;							/* 卡区域锁定 */
		byte GOSCA_SMART_CARD_LOCK				= 0x11;							/* 卡已被锁定 */
		byte GOSCA_SMART_IPPT					= 0x12;							/* IPPT提示 */
		byte GOSCA_SMART_LIMIT_WATCH			= 0x13;							/* 卡限制收看 */
		byte GOSCA_SMART_NO_WORK_TIME			= 0x14;							/* 卡不在工作时间段 */
		byte GOSCA_SMART_AREA_CONTROL_ERROR		= 0x15;							/* 卡没有工作在正确的分区内 */
		byte GOSCA_BIND_INFO_ERROR				= 0x16;							/* 机卡绑定错误 + 错误ID */
		byte GOSCA_SMART_IDRUN_ERROR			= 0x17;							/* 卡号在网络中无效错误 */
		byte GOSCA_SMART_LEVEL_ERROR			= 0x18;							/* 卡的观看级别低于节目级别 */
		byte GOSCA_PVR_ENTITLE_TIMEOUT			= 0x19;							/* PVR授权文件过期 */
		byte GOSCA_SMART_OUT					= 0x20;							/* 节目加扰 ， 请插卡 */
		byte GOSCA_SMART_INVALID				= 0x21;							/*所插入卡非高斯贝尔CA卡*/
		byte GOSCA_SMART_STB_NOBIND				= 0x22;							/*机卡未绑定时提示*/
		byte GOSCA_CASID_BIND_ERROR				= 0x23;							/*机顶盒运营商ID和运营商ID绑定错误*/
		byte GOSCA_CASID_SOL_ERROR				= 0x24;							/*开机控制SOL信息接收错误*/
		byte GOSCA_SMART_UNKNOWN_ERROR			= (byte) 0xFF;					/* 未知错误 */
	}
	
	/**
	 * 区域控制类型常量接口
	 */
	public static interface AreaCtlType
	{
		byte GOS_AREA_CONTROL_OLD	= 0;
		byte GOS_AREA_CONTROL_NEW	= 1;
		byte GOS_AREA_CONTROL_NONE	= 2;
	}
	
	/**
	 * 视频类型常量接口
	 */
	public static interface VideoType
	{
		int VIDEO_TYPE_MPEG1		= 0x01;
		int VIDEO_TYPE_MPEG2		= 0x02;
		int VIDEO_TYPE_MPEG4		= 0x10;
		int VIDEO_TYPE_H264			= 0x1B;
		int VIDEO_TYPE_AVS			= 0x42;
		int VIDEO_TYPE_WM9        	= 0xEA;
		int VIDEO_TYPE_USR        	= 0x80;
	}
	
	/**
	 * 音频类型常量接口
	 */
	public static interface AudioType
	{
		int AUDIO_TYPE_MPEG1		= 0x03;
		int AUDIO_TYPE_MPEG2		= 0x04;
		int AUDIO_TYPE_AAC_ADTS   	= 0x0F;
		int AUDIO_TYPE_AAC_LATM   	= 0x11;
		int AUDIO_TYPE_AAC_RAW    	= 0x12;
		int AUDIO_TYPE_AUX			= 0x0E;
		int AUDIO_TYPE_AVS   	 	= 0x43;
		int AUDIO_TYPE_WM9        	= 0xE6;
		int AUDIO_TYPE_AC3        	= 0x81;
		int AUDIO_TYPE_DTS        	= 0x85;
	}
	
	/**
	 *声道模式类型常量接口
	 */
	public static interface AudioMode
	{
		byte AV_STEREO_MODE_STEREO 		= 0;
		byte AV_STEREO_MODE_LEFT 		= AV_STEREO_MODE_STEREO+1;
		byte AV_STEREO_MODE_RIGHT 		= AV_STEREO_MODE_LEFT+1;
		byte AV_STEREO_MODE_ONLY_LEFT 	= AV_STEREO_MODE_RIGHT+1;
		byte AV_STEREO_MODE_ONLY_RIGHT 	= AV_STEREO_MODE_ONLY_LEFT+1;
		byte AV_STEREO_MODE_MIXED 		= AV_STEREO_MODE_ONLY_RIGHT+1;
		byte AV_STEREO_MODE_MUTED 		= AV_STEREO_MODE_MIXED+1;
	}
	
	/**
	 *Subtitle、teletext流类型常量接口
	 */
	public static interface SubtType
	{
		byte SUBT_CC_SUBTITLE			= 0;
		byte ESUBT_DVB_SUBTITLE			= 1;
		byte SUBT_SCTE_SUBTITLE			= 2;
		byte SUBT_TTX_SUBTITLE			= 3;
		byte SUBT_TTX_TELETEXT			= 4;
		byte SUBT_TYPE_BUTT				= 5;
	}
	
	/**
	 * 录制、时移等pvr相关的事件常量接口
	 */
	public static interface PvrEvent
	{
		byte PVR_EVENT_PLAY_EOF        = 0x001;          /*播放到文件尾 */
		byte PVR_EVENT_PLAY_SOF        = 0x002;          /*回退到文件头 */
		byte PVR_EVENT_PLAY_ERROR      = 0x003;          /*播放内部错误 */
		byte PVR_EVENT_PLAY_REACH_REC  = 0x004;          /*时移的时候播放追上录制 */
		byte PVR_EVENT_PLAY_RESV       = 0x00f;          /*保留 */
		byte PVR_EVENT_REC_DISKFULL    = 0x010;          /*磁盘满 */
		byte PVR_EVENT_REC_ERROR       = 0x011;          /*录制内部错误 */
		byte PVR_EVENT_REC_OVER_FIX    = 0x012;          /*录制长度达到指定的长度,只有非回绕录制才有这个事件 */
		byte PVR_EVENT_REC_REACH_PLAY  = 0x013;          /*时移的时候录制追上播放 */
		byte PVR_EVENT_REC_DISK_SLOW   = 0x014;          /*磁盘存储速度慢于录制速度 */
		byte PVR_EVENT_REC_RESV        = 0x01f;          /*保留 */
		byte PVR_EVENT_BUTT            = 0x020;          /*无效的事件类型 */
	}
	
	/**
	 *机顶盒类型常量接口
	 */
	public static interface StbType
	{
		byte STBSYS_TYPE_DVBC			= 0;
		byte STBSYS_TYPE_DVBT			= STBSYS_TYPE_DVBC + 1;
		byte STBSYS_TYPE_DVBT2			= STBSYS_TYPE_DVBT + 1;
		byte STBSYS_TYPE_QAMB			= STBSYS_TYPE_DVBT2 + 1;			// J83-B
		byte STBSYS_TYPE_ISDBT			= STBSYS_TYPE_QAMB + 1;
		byte STBSYS_TYPE_DVBS			= STBSYS_TYPE_ISDBT + 1;			// 临时设置的
		byte STBSYS_TYPE_DVBS2_DVBT2	= STBSYS_TYPE_DVBS+1;
	}
	
	/**
	 *CA类型常量接口
	 */
	public static interface CAType
	{
		byte CA_TYPE_GOS						= 0;
		byte CA_TYPE_CONAX						= CA_TYPE_GOS + 1;
		byte CA_TYPE_GRIF						= CA_TYPE_CONAX + 1;
		byte CA_TYPE_BAST						= CA_TYPE_GRIF + 1;
		byte CA_TYPE_NONE						= CA_TYPE_BAST+1;;		// 无CA,该值放在CA_TYPE_TAIHE之前，是为了与dvbct的底层配合起来，暂时先这样
		byte CA_TYPE_TAIHE						= CA_TYPE_NONE + 1;		
	}
	
	/**
	 * Tuner事件类型常量接口
	 */
	public static interface TunerEvtType
	{
		byte FE_EVENT_UNLOCK					= 0;								// tuner没有锁定，表示没有信号
		byte FE_EVENT_LOCK						= FE_EVENT_UNLOCK+1;				// tuner被锁定，表示有信号
		byte FE_EVENT_LOST						= FE_EVENT_LOCK + 1;				// 失去信号
		byte FE_EVENT_MOTOR_MOVING				= FE_EVENT_LOST+1;					//马达转动事件
		byte FE_EVENT_MOTOR_STOP				= FE_EVENT_MOTOR_MOVING+1;			//马达停止事件
		byte FE_EVENT_BUTT						= FE_EVENT_MOTOR_STOP + 1;
	}
	/**
	 * 节目排序类型常量接口
	 */
	public static interface ProSortType
	{
		int GOS_SORTBY_LCN 						= 0;
		int GOS_SORTBY_SERVICEID 				= 1;
		int GOS_SORTBY_FREQUENCY				= 2;
		int GOS_SORTBY_NAME_A_Z					= 3;
		int GOS_SORTBY_SAT						= 4;
		int GOS_SORTBY_FTA_FIRST				= 5;
		int GOS_SORTBY_NAME_Z_A					= 6;
	}
	
	/**
	 * LCN类型常量接口
	 */
	public static interface LCNType
	{
		int GOS_LCN_NORMAL 	= 0;
		int GOS_LCN_GOSPELL = 1;
		int GOS_LCN_NONE	= 2;
	}
	
	/**
	 * 节目列表类型常量接口
	 */
	public static interface ProListType
	{
		byte TV_LIST		= 0;
		byte RADIO_LIST		= 1;
		byte BAT_LIST		= 2;
		byte FAV_LIST		= 3;
		byte INVALID_LIST	= 4;
	}
	
	/**
	 * 节目类型常量接口
	 */
	public static interface ServiceType
	{
		byte eCS_DB_INVALID_SERVICE	= 0;
		byte eCS_DB_TV_SERVICE 		= 1;
		byte eCS_DB_RADIO_SERVICE 	= 2;
		byte eCS_DB_DATA_SERVICE	= 3;
	}
	
	/**
	 * 节目搜索时所处的状态类型常量接口
	 */
	public static interface SearchStatus
	{
		byte SEARCH_IDLE	= 0;		//空闲
		byte SEARCH_START	= 1;		//搜索中
		byte SEARCH_END		= 2;		//搜索结束
		byte SEARCH_ERR		= 3;		//搜索异常
	}
	
	/**
	 * 滚动广告的位置
	 */
	public static interface RollADPostion
	{
		byte ROLLAD_LEFT	= 0;		
		byte ROLLAD_REGHT	= 1;		
		byte ROLLAD_UP		= 2;		
		byte ROLLAD_DOWN	= 3;	
	}
	/**
	 * GOS CA的强制osd显示的状态常量接口
	 */
	public static interface GosCAShowStatus
	{
		byte eForceOsd_Butt		= 0;
	    byte eForceOsd_Start	= 1;
	    byte eForceOsd_Stop		= 2;
	    byte eForceOsd_Hide		= 3;
	    byte eForceOsd_Show		= 4;
	}
	
	/**
	 * 指纹显示位置常量类型接口
	 */
	public static interface FingerPosType
	{
		byte eCA_FORCE_FINGER_POSITION_DEFAULT		= 0;
	    byte eCA_FORCE_FINGER_POSITION_USERDEFINE	= 1;
	    byte eCA_FORCE_FINGER_POSITION_RANDOM		= 2;
	}
	
	/**
	 *遥控器类型对应值
	 */
	public static interface RemoteType
	{
		final int eGOS_REMOTE_GTRG002		= 0;
		final int eGOS_REMOTE_GTRG002_X		= 1;
		final int eGOS_REMOTE_GTRG003		= 2;
		final int eGOS_REMOTE_GTRG003_2		= 3;
		final int eGOS_REMOTE_GTRG003_3		= 4;
		final int eGOS_REMOTE_GTRG004		= 5;
		final int eGOS_REMOTE_GTRG006		= 6;
		final int eGOS_REMOTE_GTRGPR		= 7;
	}
	
	/**
	 * RF channel 
	 */
	public static interface IRFChannel
	{
		final int eRF_CHANNEL_3		= 0;
		final int eRF_CHANNEL_4		= 1;
	}
	
	/**
	 * RF audio mode 
	 */
	public static interface IRFAudioMode
	{
		final int eRF_NTSC_M		= 0;
		final int eRF_PAL_BG		= 1;
		final int eRF_PAL_I			= 2;
		final int eRF_PAL_DK		= 3;
	}
	/**
	 * user legal status
	 */
	public static interface IUserLegalStatus
	{
		final byte eUSER_LEGAL_STATUS_UNKNOWN	= 0;
		final byte eUSER_LEGAL_STATUS_INVALID	= 1;
		final byte eUSER_LEGAL_STATUS_VALID	= 2;	
	}
}

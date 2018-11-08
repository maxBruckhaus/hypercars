CREATE TABLE vehicle (
    v_vin     VARCHAR (40)   NOT NULL,
    v_license VARCHAR (10)   NOT NULL,
    v_year    DECIMAL (3)    NOT NULL,
    v_make    VARCHAR (10)   NOT NULL,
    v_model   VARCHAR (10)   NOT NULL,
    v_color   VARCHAR (10)   NOT NULL,
    v_price   DECIMAL (7, 2) NOT NULL
);

CREATE TABLE IF NOT EXISTS hypercars (
    h_vin      VARCHAR (40) NOT NULL,
    h_engine   VARCHAR (10) NOT NULL,
    h_topSpeed DECIMAL (3)  NOT NULL,
    h_trans    VARCHAR (10) NOT NULL,
    h_weight   DECIMAL (3)  NOT NULL
);

CREATE TABLE IF NOT EXISTS engine (
    e_model     VARCHAR (10) NOT NULL,
    e_make      VARCHAR (10) NOT NULL,
    e_cylinders DECIMAL (1)  NOT NULL,
    e_hp        DECIMAL (10) NOT NULL,
    e_torque    DECIMAL (10) NOT NULL,
    e_size      DECIMAL (10) NOT NULL
);

CREATE TABLE transmission (
    t_model VARCHAR (10) NOT NULL,
    t_gears DECIMAL (1)  NOT NULL,
    t_type  BOOLEAN      NOT NULL
);

CREATE TABLE wheels (
    w_model       [E_HS BOOLEAN] NOT NULL,
    e_leather     BOOLEAN        NOT NULL,
    e_turbo       BOOLEAN        NOT NULL,
    e_spoiler     BOOLEAN        NOT NULL,
    e_tint        BOOLEAN        NOT NULL,
    e_convertible BOOLEAN        NOT NULL
);

CREATE TABLE manufacturer (
    m_name   VARCHAR (10)    NOT NULL,
    m_nation VARCHAR (10)    NOT NULL,
    m_sales  DECIMAL (10, 2) NOT NULL
);
INSERT INTO vehicle
        (v_vin, v_license, v_year, v_make, v_model, v_color, v_price) VALUES
	("JH4KA2650HC000268", 2, 1987, "Acura", "Legend", "BLACK", 4265),
	("4JGBB86E27A199749", 2, 2007, "Mercedes Benz", "M Class", "BLACK", 20265),
	("3B7HF13Y81G193584", 2, 2001, "Dodge", "Ram Pickup 1500", "BLUE", 30125),
	("1HGCT2B88DA000025", 2, 2013, "Honda", "Accord", "WHITE", 15843),
	("JH4DB8580RS000024", 2, 1994, "Acura", "Integra", "BLUE", 3953),
	("4S3BK6354S6355265", 2, 1995, "Subaru", "Legacy", "GRAY", 6632),
	("5NPEB4AC1DH576656", 2, 2013, "Hyundai", "Sonata", "PINK", 29473),
	("JH4KA4576KC031014", 2, 1989, "Acura", "Legend", "WHITE", 3046),
	("JH4NA1260MT001906", 2, 1991, "Acura", "NSX", "RED", 3046),
	("1FAFP55U91A180689", 2, 2001, "Ford", "Taurus", "BLACK", 3953),
	("SCA1S684X4UX07444", 2, 2004, "Rolls Royce", "Phantom", "BLACK", 200367),
	("3VWRA69M74M033915", 2, 2004, "Volkswagen", "Jetta", "BLUE", 3953),
	("1GNEK13T7YJ204464", 2, 2000, "Chevrolet", "Tahoe", "WHITE", 9263),
	("2C3CCAET4CH256062", 2, 2012, "Chrysler", "300C", "PINK", 3953),
	("ZFFXS41A7X0114158", 2, 1999, "Ferrari", "F355", "RED", 3874905),
	("ZFFEZ58E170153605", 2, 2012, "Ferrari", "F430 Coupe", "YELLOW", 494734),
	("ZFFEW58A660144998", 2, 2006, "Ferrari", "F430", "BLUE", 35232),
	("ZFFWL44A330131232", 2, 2003, "Ferrari", "456M", "WHITE", 558376),
	("ZFFWP50A0V0106629", 2, 1997, "Ferrari", "456", "RED", 29457),
	("ZFFEW58L170151456", 2, 2007, "Ferrari", "F430 Coupe", "PINK", 35232),
	("ZFFAB54A080014783", 2, 2008, "Ferrari", "612", "BLUE", 35232),
	("SCBCR63W55C024793", 2, 2005, "Bentley", "Continental GT", "RED", 39584),
	("SCBZP03A9MCH33794", 2, 1991, "Bentley", "Turbo", "GRAY", 290423),


INSERT INTO hypercars
        (h_vin, h_engine, h_topSpeed, h_trans, h_weight) VALUES
        (1,2,3,4,5),
        (1,2,3,4,5);
INSERT INTO engine
        (e_model, e_make, e_cylinders, e_hp, e_torque, e_size) VALUES
        (1,2,3,4,5,6),
        (1,2,3,4,5,6);
INSERT INTO transmission
        (t_model, t_gears, t_type) VALUES
        (1,2,3),
        (1,2,3);
INSERT INTO wheels
        (w_model, e_leather, e_turbo, e_spoiler, e_tint, e_convertible) VALUES
        (1,2,3,4,5,6),
        (1,2,3,4,5,6);
INSERT INTO manufacturer
        (m_name, m_nation, m_sales) VALUES
        (1,2,3),
        (1,2,3);

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

-- https://vingenerator.org/brand
INSERT INTO vehicle
        (v_vin, v_license, v_year, v_make, v_model, v_color, v_price) VALUES
	("JH4KA2650HC000268", "123ABC0", 1987, "Acura", "Legend", "BLACK", 4265),
	("4JGBB86E27A199749", "123ABC1", 2007, "Mercedes Benz", "M Class", "BLACK", 20265),
	("3B7HF13Y81G193584", "123ABC2", 2001, "Dodge", "Ram Pickup 1500", "BLUE", 30125),
	("1HGCT2B88DA000025", "123ABC3", 2013, "Honda", "Accord", "WHITE", 15843),
	("JH4DB8580RS000024", "123ABC4", 1994, "Acura", "Integra", "BLUE", 3953),
	("4S3BK6354S6355265", "123ABC5", 1995, "Subaru", "Legacy", "GRAY", 6632),
	("5NPEB4AC1DH576656", "123ABC6", 2013, "Hyundai", "Sonata", "PINK", 29473),
	("JH4KA4576KC031014", "123ABC7", 1989, "Acura", "Legend", "WHITE", 3046),
	("JH4NA1260MT001906", "123ABC8", 1991, "Acura", "NSX", "RED", 3046),
	("1FAFP55U91A180689", "123ABC9", 2001, "Ford", "Taurus", "BLACK", 3953),
	("SCA1S684X4UX07444", "123ABD0", 2004, "Rolls Royce", "Phantom", "BLACK", 200367),
	("3VWRA69M74M033915", "123ABD1", 2004, "Volkswagen", "Jetta", "BLUE", 3953),
	("1GNEK13T7YJ204464", "123ABD2", 2000, "Chevrolet", "Tahoe", "WHITE", 9263),
	("2C3CCAET4CH256062", "123ABD3", 2012, "Chrysler", "300C", "PINK", 3953),
	("ZFFXS41A7X0114158", "123ABD4", 1999, "Ferrari", "F355", "RED", 3874905),
	("ZFFEZ58E170153605", "123ABD5", 2012, "Ferrari", "F430 Coupe", "YELLOW", 494734),
	("ZFFEW58A660144998", "123ABD6", 2006, "Ferrari", "F430", "BLUE", 35232),
	("ZFFWL44A330131232", "123ABD7", 2003, "Ferrari", "456M", "WHITE", 558376),
	("ZFFWP50A0V0106629", "123ABD8", 1997, "Ferrari", "456", "RED", 29457),
	("ZFFEW58L170151456", "123ABD9", 2007, "Ferrari", "F430 Coupe", "PINK", 35232),
	("ZFFAB54A080014783", "123ABE0", 2008, "Ferrari", "612", "BLUE", 35232),
	("SCBCR63W55C024793", "123ABE1", 2005, "Bentley", "Continental GT", "RED", 39584),
	("SCBFT7ZA3FC041545", "123ABE2", 2015, "Bentley", "Continental GT V8", "PINK", 25344),
	("SCBZS42A5CCX05753", "123ABE3", 1982, "Bentley", "Mulsanne", "BLUE", 83945),
	("SCBLC37F04CX09874", "123ABE4", 2004, "Bentley", "Arnage", "RED", 93405),
	("SCBBP9ZA0AC062683", "123ABE5", 2010, "Bentley", "Continental Flying Spur Speed", "WHITE", 20492),
	("SCBBB7ZH1EC118746", "123ABE6", 2014, "Bentley", "Mulsanne", "PINK", 83945),
	("SCBCR63W55C024793", "123ABE7", 2005, "Bentley", "Continental GT", "RED", 83945);

INSERT INTO hypercars
        (h_vin, h_engine, h_topSpeed, h_trans, h_weight) VALUES
	("JH4KA2650HC000268", "NVPVK6NE", 136, "BKRKZ", 1993),
	("4JGBB86E27A199749", "QU875TE8", 200, "RY85H", 2489),
	("3B7HF13Y81G193584", "R6NAYRET", 216, "9562C", 2075),
	("1HGCT2B88DA000025", "F9V5B0H4", 156, "XZMOH", 2639),
	("JH4DB8580RS000024", "F5UD9B4L", 272, "MO7OL", 1829),
	("4S3BK6354S6355265", "3ESQ1YMY", 296, "DFWY5", 1821),
	("5NPEB4AC1DH576656", "U5LSNFMZ", 207, "XE8YG", 1929),
	("JH4KA4576KC031014", "XF8OIUQ2", 103, "A259G", 1695),
	("JH4NA1260MT001906", "08A7XDMB", 107, "94CMC", 1682),
	("1FAFP55U91A180689", "4G2FK0EI", 197, "J3WO8", 2772),
	("SCA1S684X4UX07444", "U71AZ4GB", 194, "ARFAI", 2725),
	("3VWRA69M74M033915", "7U6F42X5", 138, "CTRHW", 1600),
	("1GNEK13T7YJ204464", "NKVDM332", 262, "ZZMB0", 2570),
	("2C3CCAET4CH256062", "4S11N0XC", 168, "76H1W", 2288),
	("ZFFXS41A7X0114158", "O62PTZ1N", 253, "5VDJB", 2152),
	("ZFFEZ58E170153605", "QPBS0F1M", 147, "LVMS0", 1798),
	("ZFFEW58A660144998", "Y3GP756Y", 200, "T786J", 2299),
	("ZFFWL44A330131232", "GH01ME9J", 257, "SP0PJ", 2224),
	("ZFFWP50A0V0106629", "KVQW1Z3K", 253, "659TT", 2402),
	("ZFFEW58L170151456", "39L2Y02Z", 179, "54MXT", 1801),
	("ZFFAB54A080014783", "DK4MQEZM", 180, "OB9UN", 1976),
	("SCBCR63W55C024793", "PU69GAWZ", 122, "2W0WV", 1821),
	("SCBFT7ZA3FC041545", "QAXYHVY6", 157, "58QOP", 2662),
	("SCBZS42A5CCX05753", "A4BHKQL5", 183, "JEL1R", 1508),
	("SCBLC37F04CX09874", "QXEZJCHG", 173, "80R8D", 1782),
	("SCBBP9ZA0AC062683", "SXTCKS3V", 122, "GN4WS", 1574),
	("SCBBB7ZH1EC118746", "LL7D6884", 147, "XW9HN", 2027),
	("SCBCR63W55C024793", "2WGW2ZJH", 158, "AADF5", 1741);

INSERT INTO engine
        (e_model, e_make, e_cylinders, e_hp, e_torque, e_size) VALUES
	("NVPVK6NE", "Acura", "BKRKZ", 6, 602, 2.8),
	("QU875TE8", "Mercedes Benz", "RY85H", 6, 532, 7.9),
	("R6NAYRET", "Dodge", "9562C", 8, 764, 1.6),
	("F9V5B0H4", "Honda", "XZMOH", 4, 709, 7.0),
	("F5UD9B4L", "Acura", "MO7OL", 4, 774, 5.5),
	("3ESQ1YMY", "Subaru", "DFWY5", 6, 764, 6.7),
	("U5LSNFMZ", "Hyundai", "XE8YG", 6, 626, 3.1),
	("XF8OIUQ2", "Acura", "A259G", 6, 676, 5.2),
	("08A7XDMB", "Acura", "94CMC", 6, 588, 1.6),
	("4G2FK0EI", "Ford", "J3WO8", 6, 671, 2.9),
	("U71AZ4GB", "Rolls Royce", "ARFAI", 12, 606, 5.7),
	("7U6F42X5", "Volkswagen", "CTRHW", 6, 677, 2.3),
	("NKVDM332", "Chevrolet", "ZZMB0", 6, 630, 2.5),
	("4S11N0XC", "Chrysler", "76H1W", 6, 689, 3.6),
	("O62PTZ1N", "Ferrari", "5VDJB", 12, 675, 4.2),
	("QPBS0F1M", "Ferrari", "LVMS0", 12, 691, 3.9),
	("Y3GP756Y", "Ferrari", "T786J", 12, 771, 2.9),
	("GH01ME9J", "Ferrari", "SP0PJ", 12, 577, 4.9),
	("KVQW1Z3K", "Ferrari", "659TT", 12, 739, 3.5),
	("39L2Y02Z", "Ferrari", "54MXT", 12, 627, 2.6),
	("DK4MQEZM", "Ferrari", "OB9UN", 12, 567, 4.1),
	("PU69GAWZ", "Bentley", "2W0WV", 12, 626, 1.2),
	("QAXYHVY6", "Bentley", "58QOP", 12, 608, 4.1),
	("A4BHKQL5", "Bentley", "JEL1R", 12, 581, 4.7),
	("QXEZJCHG", "Bentley", "80R8D", 12, 807, 5.6),
	("SXTCKS3V", "Bentley", "GN4WS", 12, 781, 5.3),
	("LL7D6884", "Bentley", "XW9HN", 12, 568, 3.6),
	("2WGW2ZJH", "Bentley", "AADF5", 12, 545, 2.7);
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

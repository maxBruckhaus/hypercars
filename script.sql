CREATE TABLE IF NOT EXISTS vehicle (
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
    h_weight   DECIMAL (3)  NOT NULL,
    h_wheel    VARCHAR (10) NOT NULL
);

CREATE TABLE IF NOT EXISTS engine (
    e_model     VARCHAR (10) NOT NULL,
    e_make      VARCHAR (10) NOT NULL,
    e_cylinders DECIMAL (1)  NOT NULL,
    e_hp        DECIMAL (10) NOT NULL,
    e_torque    DECIMAL (10) NOT NULL,
    e_size      DECIMAL (10) NOT NULL
);

CREATE TABLE IF NOT EXISTS transmission (
    t_model VARCHAR (10) NOT NULL,
    t_gears DECIMAL (1)  NOT NULL,
    t_type  BOOLEAN      NOT NULL
);

CREATE TABLE IF NOT EXISTS wheels (
    w_model       VARCHAR (10)   NOT NULL,
    w_make        VARCHAR (10)   NOT NULL,
    w_height      DECIMAL (3)    NOT NULL,
    w_width       DECIMAL (3)    NOT NULL,
    w_rim         DECIMAL (3)    NOT NULL,
    w_diameter    DECIMAL (3)    NOT NULL
);

CREATE TABLE IF NOT EXISTS manufacturer (
    m_name   VARCHAR (10)    NOT NULL,
    m_nation VARCHAR (10)    NOT NULL,
    m_sales  DECIMAL (10, 2) NOT NULL
);

CREATE TABLE IF NOT EXISTS extras (
    ex_model       VARCHAR (40)   NOT NULL,
    ex_heated      BOOLEAN        NOT NULL,
    ex_leather     BOOLEAN        NOT NULL,
    ex_turbo       BOOLEAN        NOT NULL,
    ex_spoiler     BOOLEAN        NOT NULL,
    ex_tint        BOOLEAN        NOT NULL,
    ex_convertible BOOLEAN        NOT NULL
);

CREATE TABLE IF NOT EXISTS  people (
    p_license     VARCHAR        NOT NULL,
    p_phone       DECIMAL        NOT NULL,
    p_name        VARCHAR        NOT NULL,
    p_email       VARCHAR        NOT NULL,
    p_age         DECIMAL        NOT NULL
);

CREATE TABLE IF NOT EXISTS bids (
    b_ID              VARCHAR    NOT NULL,
    b_price           DECIMAL    NOT NULL,
    b_licensePlate    VARCHAR    NOT NULL,
    b_name            VARCHAR    NOT NULL,
    b_phone           DECIMAL    NOT NULL
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
	("SCBCR63WS5C024793", "123ABE1", 2005, "Bentley", "Continental GT", "RED", 39584),
	("SCBFT7ZA3FC041545", "123ABE2", 2015, "Bentley", "Continental GT V8", "PINK", 25344),
	("SCBZS42A5CCX05753", "123ABE3", 1982, "Bentley", "Mulsanne", "BLUE", 83945),
	("SCBLC37F04CX09874", "123ABE4", 2004, "Bentley", "Arnage", "RED", 93405),
	("SCBBP9ZA0AC062683", "123ABE5", 2010, "Bentley", "Continental Flying Spur Speed", "WHITE", 20492),
	("SCBBB7ZH1EC118746", "123ABE6", 2014, "Bentley", "Mulsanne", "PINK", 83945),
	("SCBCR63W55C024793", "123ABE7", 2005, "Bentley", "Continental GT", "RED", 83945),

	("WVFWPKR4D5KRM1RBL", "V7WPW0G", 2007, "Mercedes Benz", "M Class", "BLACK", 20265),
	("PWZIGRBDT7UDPE5JA", "T52PU5Q", 2001, "Dodge", "Ram Pickup 1500", "BLUE", 30125),
	("RKNXEKKC2USFZ96T0", "8F5FK2Q", 2013, "Honda", "Accord", "WHITE", 15843),
	("HBHTCU3ULYPSUDI80", "JUMECQC", 1994, "Acura", "Integra", "BLUE", 3953),
	("XIYSIC2K3FS6JIY03", "05UN4IK", 1995, "Subaru", "Legacy", "GRAY", 6632),
	("RGBXCA94EMG4DGZXU", "2ZZRVKR", 2013, "Hyundai", "Sonata", "PINK", 29473),
	("ZYRRUXQZL0QY6PF5M", "NV7PD25", 1989, "Acura", "Legend", "WHITE", 3046),
	("YNOPGKKBOQKM5NOR5", "Q1Y1BTF", 1991, "Acura", "NSX", "RED", 3046),
	("USSWPZ76DAKC3PCOF", "R0WXNAA", 2001, "Ford", "Taurus", "BLACK", 3953),
	("EFSJTA1FQSS3HGWHX", "CWOH0VZ", 2004, "Rolls Royce", "Phantom", "BLACK", 200367),
	("HCJKJHKY7022ZR3NQ", "ODCDADC", 2004, "Volkswagen", "Jetta", "BLUE", 3953),
	("CNBVPGH6Q84ONUJ5I", "RQYZZTA", 2000, "Chevrolet", "Tahoe", "WHITE", 9263),
	("WTFWASRUU6ZLTRNBU", "0XIPO8U", 2012, "Chrysler", "300C", "PINK", 3953),
	("YXIXTM1WV4RJO1DZ8", "WL6INN8", 1999, "Ferrari", "F355", "RED", 3874905),
	("VSJJWWQ5YOLE4CJ4D", "Z7B33AF", 2012, "Ferrari", "F430 Coupe", "YELLOW", 494734),
	("ESEERJN2D4XI6VVXI", "DSSGR9L", 2006, "Ferrari", "F430", "BLUE", 35232),
	("XNXWFNQX0K3RPKM4J", "INTD9XZ", 2003, "Ferrari", "456M", "WHITE", 558376),
	("NLVEXWWE8HSBM3MZH", "IOI4IDI", 1997, "Ferrari", "456", "RED", 29457),
	("CEZXQBFOUGOOU03IP", "7Z3PA8S", 2007, "Ferrari", "F430 Coupe", "PINK", 35232),
	("NXVLGAR0NBUHF04NU", "V6E44QN", 2008, "Ferrari", "612", "BLUE", 35232),
	("OYHJIR7XS7MLTKX1T", "26OR95W", 2005, "Bentley", "Continental GT", "RED", 39584),
	("PVUSHAR7HLXDN3G5S", "MGRD7XX", 2015, "Bentley", "Continental GT V8", "PINK", 25344),
	("RJUDLUTU8GD8GL7Y7", "G37TWY4", 1982, "Bentley", "Mulsanne", "BLUE", 83945),
	("GZABPO5XTB32KVZA3", "JKXI17S", 2004, "Bentley", "Arnage", "RED", 93405),
	("UOQIFOEYRX7COMKEA", "PZ6BYMG", 2010, "Bentley", "Continental Flying Spur Speed", "WHITE", 20492),
	("VDRABF8GY8SZXQHQJ", "0GFHBGB", 2014, "Bentley", "Mulsanne", "PINK", 83945),
	("SCBCR63W55C624793", "G37THY4", 2005, "Bentley", "Continental GT", "RED", 83945);




INSERT INTO hypercars
  (h_vin, h_engine, h_topSpeed, h_trans, h_weight, h_wheel) VALUES
	("JH4KA2650HC000268", "NVPVK6NE", 136, "BKRKZ", 1993, "V6UKMC"),
	("4JGBB86E27A199749", "QU875TE8", 201, "RY85H", 2489, "3T4774"),
	("3B7HF13Y81G193584", "R6NAYRET", 216, "9562C", 2075, "ARBYW5"),
	("1HGCT2B88DA000025", "F9V5B0H4", 156, "XZMOH", 2639, "F1ZY06"),
	("JH4DB8580RS000024", "F5UD9B4L", 272, "MO7OL", 1829, "962V3D"),
	("4S3BK6354S6355265", "3ESQ1YMY", 296, "DFWY5", 1821, "6CSNS3"),
	("5NPEB4AC1DH576656", "U5LSNFMZ", 207, "XE8YG", 1929, "FLSGEK"),
	("JH4KA4576KC031014", "XF8OIUQ2", 103, "A259G", 1695, "7Q7NH2"),
	("JH4NA1260MT001906", "08A7XDMB", 107, "94CMC", 1682, "6E8TX7"),
	("1FAFP55U91A180689", "4G2FK0EI", 197, "J3WO8", 2772, "86NNTT"),
	("SCA1S684X4UX07444", "U71AZ4GB", 194, "ARFAI", 2725, "1E7P81"),
	("3VWRA69M74M033915", "7U6F42X5", 138, "CTRHW", 1600, "1TD6GP"),
	("1GNEK13T7YJ204464", "NKVDM332", 262, "ZZMB0", 2570, "XD62CM"),
	("2C3CCAET4CH256062", "4S11N0XC", 168, "76H1W", 2288, "5EJXV8"),
	("ZFFXS41A7X0114158", "O62PTZ1N", 263, "5VDJB", 2152, "VFMDJS"),
	("ZFFEZ58E170153605", "QPBS0F1M", 187, "LVMS0", 1798, "C8BR7A"),
	("ZFFEW58A660144998", "Y3GP756Y", 200, "T786J", 2299, "SS3CVF"),
	("ZFFWL44A330131232", "GH01ME9J", 257, "SP0PJ", 2224, "T4PD0N"),
	("ZFFWP50A0V0106629", "KVQW1Z3K", 253, "659TT", 2402, "JKQBAH"),
	("ZFFEW58L170151456", "39L2Y02Z", 179, "54MXT", 1801, "G1YM7N"),
	("ZFFAB54A080014783", "DK4MQEZM", 180, "OB9UN", 1976, "TTCEK7"),
	("SCBCR63WS5C024793", "PU69GAWZ", 132, "2W0WV", 1821, "SFJJ7H"),
	("SCBFT7ZA3FC041545", "QAXYHVY6", 157, "58QOP", 2662, "RFIT0O"),
	("SCBZS42A5CCX05753", "A4BHKQL5", 183, "JEL1R", 1508, "JZR2WL"),
	("SCBLC37F04CX09874", "QXEZJCHG", 173, "80R8D", 1782, "D8HE5U"),
	("SCBBP9ZA0AC062683", "SXTCKS3V", 122, "GN4WS", 1574, "R1VLJW"),
	("SCBBB7ZH1EC118746", "LL7D6884", 147, "XW9HN", 2027, "1L6IGJ"),
	("SCBCR63W55C024793", "2WGW2ZJH", 158, "AADF5", 1741, "KGER55"),

	("WVFWPKR4D5KRM1RBL", "3QPQJZ0Y", 201, "77WBQ", 2489, "YUUNGM"),
	("PWZIGRBDT7UDPE5JA", "62929049", 216, "6YU9F", 2075, "HRO7DE"),
	("RKNXEKKC2USFZ96T0", "M5QG2U36", 156, "7GQWY", 2639, "2Z2KK9"),
	("HBHTCU3ULYPSUDI80", "BY9ZYD39", 272, "Q76RI", 1829, "J9LK5J"),
	("XIYSIC2K3FS6JIY03", "A792XL4U", 296, "D947F", 1821, "SHT14P"),
	("RGBXCA94EMG4DGZXU", "RV8FFF84", 207, "1N6O7", 1929, "MU0DFA"),
	("ZYRRUXQZL0QY6PF5M", "43VXLXBX", 103, "BHQDJ", 1695, "47O37N"),
	("YNOPGKKBOQKM5NOR5", "PKNSJ8XD", 107, "5NBMM", 1682, "E56G4Y"),
	("USSWPZ76DAKC3PCOF", "8N4CJI5D", 197, "XHCIQ", 2772, "P2O7TY"),
	("EFSJTA1FQSS3HGWHX", "S3OIZRNM", 194, "LK8LA", 2725, "WEC4YI"),
	("HCJKJHKY7022ZR3NQ", "13ZNAW9C", 138, "2CKE8", 1600, "3RN8P9"),
	("CNBVPGH6Q84ONUJ5I", "QKPJ0FO6", 262, "F3NWW", 2570, "6BLPPT"),
	("WTFWASRUU6ZLTRNBU", "CZ9KD78V", 168, "VMRV9", 2288, "JO8AT9"),
	("YXIXTM1WV4RJO1DZ8", "M3XLTDDU", 263, "H0SO9", 2152, "U2WK8E"),
	("VSJJWWQ5YOLE4CJ4D", "PJ1368SN", 187, "BO3T4", 1798, "KUUFZE"),
	("ESEERJN2D4XI6VVXI", "LAORLHDZ", 200, "OK6J0", 2299, "BP9QOH"),
	("XNXWFNQX0K3RPKM4J", "XCZH0Y7G", 257, "CNG4N", 2224, "6JK4M6"),
	("NLVEXWWE8HSBM3MZH", "RQ5DNS3L", 253, "N6A9F", 2402, "NQWPT5"),
	("CEZXQBFOUGOOU03IP", "7HADKLMF", 179, "4HGTN", 1801, "IMRV97"),
	("NXVLGAR0NBUHF04NU", "5LC5S6GT", 180, "2YN4F", 1976, "51M9N3"),
	("OYHJIR7XS7MLTKX1T", "THHXUFVE", 132, "19P36", 1821, "QJQ3W5"),
	("PVUSHAR7HLXDN3G5S", "35KOTF8G", 157, "O1IED", 2662, "LXYLFJ"),
	("RJUDLUTU8GD8GL7Y7", "3MDC7L1L", 183, "3Z8KX", 1508, "KMMASZ"),
	("GZABPO5XTB32KVZA3", "E2PA2NEB", 173, "1N48C", 1782, "T9PODS"),
	("UOQIFOEYRX7COMKEA", "LKHSI4OE", 122, "BOWED", 1574, "J2WVUJ"),
	("VDRABF8GY8SZXQHQJ", "OWL1LY3J", 147, "I3FT0", 2027, "4RR7LF"),
	("SCBCR63W55C624793", "PJSI48SN", 158, "38TAW", 1741, "4HLNQ2");

INSERT INTO engine
  (e_model, e_make, e_cylinders, e_hp, e_torque, e_size) VALUES
	("NVPVK6NE", "Acura", 6, 496, 602, 2.8),
	("QU875TE8", "Mercedes Benz", 6, 438, 532, 7.9),
	("R6NAYRET", "Dodge", 8, 510, 764, 1.6),
	("F9V5B0H4", "Honda", 4, 372, 709, 7.0),
	("F5UD9B4L", "Acura", 4, 440, 774, 5.5),
	("3ESQ1YMY", "Subaru", 6, 351, 764, 6.7),
	("U5LSNFMZ", "Hyundai", 6, 497, 626, 3.1),
	("XF8OIUQ2", "Acura", 6, 477, 676, 5.2),
	("08A7XDMB", "Acura", 6, 540, 588, 1.6),
	("4G2FK0EI", "Ford", 6, 429, 671, 2.9),
	("U71AZ4GB", "Rolls Royce", 12, 594, 606, 5.7),
	("7U6F42X5", "Volkswagen", 6, 448, 677, 2.3),
	("NKVDM332", "Chevrolet", 6, 365, 630, 2.5),
	("4S11N0XC", "Chrysler", 6, 521, 689, 3.6),
	("O62PTZ1N", "Ferrari", 12, 428, 675, 4.2),
	("QPBS0F1M", "Ferrari", 12, 394, 691, 3.9),
	("Y3GP756Y", "Ferrari", 12, 414, 771, 2.9),
	("GH01ME9J", "Ferrari", 12, 584, 577, 4.9),
	("KVQW1Z3K", "Ferrari", 12, 587, 739, 3.5),
	("39L2Y02Z", "Ferrari", 12, 514, 627, 2.6),
	("DK4MQEZM", "Ferrari", 12, 555, 567, 4.1),
	("PU69GAWZ", "Bentley", 12, 367, 626, 1.2),
	("QAXYHVY6", "Bentley", 12, 378, 608, 4.1),
	("A4BHKQL5", "Bentley", 12, 485, 581, 4.7),
	("QXEZJCHG", "Bentley", 12, 500, 807, 5.6),
	("SXTCKS3V", "Bentley", 12, 398, 781, 5.3),
	("LL7D6884", "Bentley", 12, 579, 568, 3.6),
	("2WGW2ZJH", "Bentley", 12, 311, 545, 2.7),

	("3QPQJZ0Y", "Mercedes Benz", 6, 438, 532, 7.9),
	("62929049", "Dodge", 8, 510, 764, 1.6),
	("M5QG2U36", "Honda", 4, 372, 709, 7.0),
	("BY9ZYD39", "Acura", 4, 440, 774, 5.5),
	("A792XL4U", "Subaru", 6, 351, 764, 6.7),
	("RV8FFF84", "Hyundai", 6, 497, 626, 3.1),
	("43VXLXBX", "Acura", 6, 477, 676, 5.2),
	("PKNSJ8XD", "Acura", 6, 540, 588, 1.6),
	("8N4CJI5D", "Ford", 6, 429, 671, 2.9),
	("S3OIZRNM", "Rolls Royce", 12, 594, 606, 5.7),
	("13ZNAW9C", "Volkswagen", 6, 448, 677, 2.3),
	("QKPJ0FO6", "Chevrolet", 6, 365, 630, 2.5),
	("CZ9KD78V", "Chrysler", 6, 521, 689, 3.6),
	("M3XLTDDU", "Ferrari", 12, 428, 675, 4.2),
	("PJ1368SN", "Ferrari", 12, 394, 691, 3.9),
	("LAORLHDZ", "Ferrari", 12, 414, 771, 2.9),
	("XCZH0Y7G", "Ferrari", 12, 584, 577, 4.9),
	("RQ5DNS3L", "Ferrari", 12, 587, 739, 3.5),
	("7HADKLMF", "Ferrari", 12, 514, 627, 2.6),
	("5LC5S6GT", "Ferrari", 12, 555, 567, 4.1),
	("THHXUFVE", "Bentley", 12, 367, 626, 1.2),
	("35KOTF8G", "Bentley", 12, 378, 608, 4.1),
	("3MDC7L1L", "Bentley", 12, 485, 581, 4.7),
	("E2PA2NEB", "Bentley", 12, 500, 807, 5.6),
	("LKHSI4OE", "Bentley", 12, 398, 781, 5.3),
	("OWL1LY3J", "Bentley", 12, 579, 568, 3.6),
	("PJSI48SN", "Bentley", 12, 311, 545, 2.7);

INSERT INTO transmission
  (t_model, t_gears, t_type) VALUES
	("BKRKZ", 5, 1),
	("RY85H", 5, 1),
	("9562C", 6, 0),
	("XZMOH", 5, 0),
	("MO7OL", 5, 1),
	("DFWY5", 5, 1),
	("XE8YG", 6, 1),
	("A259G", 5, 1),
	("94CMC", 6, 0),
	("J3WO8", 5, 1),
	("ARFAI", 6, 1),
	("CTRHW", 5, 1),
	("ZZMB0", 6, 0),
	("76H1W", 6, 1),
	("5VDJB", 5, 0),
	("LVMS0", 5, 1),
	("T786J", 5, 1),
	("SP0PJ", 6, 0),
	("659TT", 5, 0),
	("54MXT", 5, 0),
	("OB9UN", 6, 0),
	("2W0WV", 6, 1),
	("58QOP", 6, 0),
	("JEL1R", 5, 0),
	("80R8D", 6, 0),
	("GN4WS", 6, 1),
	("XW9HN", 5, 1),
	("AADF5", 5, 1),

	("77WBQ", 5, 1),
	("6YU9F", 6, 0),
	("7GQWY", 5, 0),
	("Q76RI", 5, 1),
	("D947F", 5, 1),
	("1N6O7", 6, 1),
	("BHQDJ", 5, 1),
	("5NBMM", 6, 0),
	("XHCIQ", 5, 1),
	("LK8LA", 6, 1),
	("2CKE8", 5, 1),
	("F3NWW", 6, 0),
	("VMRV9", 6, 1),
	("H0SO9", 5, 0),
	("BO3T4", 5, 1),
	("OK6J0", 5, 1),
	("CNG4N", 6, 0),
	("N6A9F", 5, 0),
	("4HGTN", 5, 0),
	("2YN4F", 6, 0),
	("19P36", 6, 1),
	("O1IED", 6, 0),
	("3Z8KX", 5, 0),
	("1N48C", 6, 0),
	("BOWED", 6, 1),
	("I3FT0", 5, 1),
	("38TAW", 5, 1);

INSERT INTO wheels
        (w_model, w_make, w_height, w_width, w_rim, w_diameter) VALUES
        ("V6UKMC", "CIARW", 24, 13.64, 8.06, 29.71),
        ("3T4774", "JYFZP", 20, 12.30, 8.23, 22.25),
        ("ARBYW5", "QQXKH", 24, 14.29, 8.59, 26.41),
        ("F1ZY06", "TWZNB", 24, 13.76, 8.35, 18.27),
        ("962V3D", "OAZAX", 22, 16.85, 8.29, 27.85),
        ("6CSNS3", "HNVQZ", 25, 12.09, 8.89, 21.24),
        ("FLSGEK", "CIARW", 24, 16.96, 7.99, 27.00),
        ("7Q7NH2", "JYFZP", 24, 14.18, 8.20, 26.04),
        ("6E8TX7", "QQXKH", 21, 15.21, 7.58, 24.93),
        ("86NNTT", "TWZNB", 20, 17.40, 7.91, 26.06),
        ("1E7P81", "OAZAX", 24, 17.99, 8.49, 26.05),
        ("1TD6GP", "HNVQZ", 20, 12.39, 7.32, 20.38),
        ("XD62CM", "CIARW", 24, 16.62, 7.84, 21.62),
        ("5EJXV8", "JYFZP", 23, 16.53, 7.03, 23.41),
        ("VFMDJS", "QQXKH", 25, 13.78, 8.88, 19.35),
        ("C8BR7A", "TWZNB", 20, 17.35, 7.26, 25.40),
        ("SS3CVF", "OAZAX", 20, 14.41, 7.24, 23.56),
        ("T4PD0N", "HNVQZ", 25, 14.46, 7.18, 25.36),
        ("JKQBAH", "CIARW", 24, 12.91, 7.97, 18.15),
        ("G1YM7N", "JYFZP", 22, 14.95, 7.21, 19.32),
        ("TTCEK7", "QQXKH", 21, 16.39, 7.46, 26.33),
        ("SFJJ7H", "TWZNB", 22, 16.66, 7.01, 24.58),
        ("RFIT0O", "OAZAX", 25, 13.35, 7.14, 21.17),
        ("JZR2WL", "HNVQZ", 21, 13.27, 8.40, 18.64),
        ("D8HE5U", "CIARW", 21, 12.66, 8.55, 20.00),
        ("R1VLJW", "JYFZP", 24, 17.15, 7.60, 29.35),
        ("1L6IGJ", "QQXKH", 22, 14.15, 7.15, 26.40),
        ("KGER55", "TWZNB", 20, 17.38, 8.67, 22.75),

	      ("YUUNGM", "JYFZP", 20, 12.30, 8.23, 22.25),
        ("HRO7DE", "QQXKH", 24, 14.29, 8.59, 26.41),
        ("2Z2KK9", "TWZNB", 24, 13.76, 8.35, 18.27),
        ("J9LK5J", "OAZAX", 22, 16.85, 8.29, 27.85),
        ("SHT14P", "HNVQZ", 25, 12.09, 8.89, 21.24),
        ("MU0DFA", "CIARW", 24, 16.96, 7.99, 27.00),
        ("47O37N", "JYFZP", 24, 14.18, 8.20, 26.04),
        ("E56G4Y", "QQXKH", 21, 15.21, 7.58, 24.93),
        ("P2O7TY", "TWZNB", 20, 17.40, 7.91, 26.06),
        ("WEC4YI", "OAZAX", 24, 17.99, 8.49, 26.05),
        ("3RN8P9", "HNVQZ", 20, 12.39, 7.32, 20.38),
        ("6BLPPT", "CIARW", 24, 16.62, 7.84, 21.62),
        ("JO8AT9", "JYFZP", 23, 16.53, 7.03, 23.41),
        ("U2WK8E", "QQXKH", 25, 13.78, 8.88, 19.35),
        ("KUUFZE", "TWZNB", 20, 17.35, 7.26, 25.40),
        ("BP9QOH", "OAZAX", 20, 14.41, 7.24, 23.56),
        ("6JK4M6", "HNVQZ", 25, 14.46, 7.18, 25.36),
        ("NQWPT5", "CIARW", 24, 12.91, 7.97, 18.15),
        ("IMRV97", "JYFZP", 22, 14.95, 7.21, 19.32),
        ("51M9N3", "QQXKH", 21, 16.39, 7.46, 26.33),
        ("QJQ3W5", "TWZNB", 22, 16.66, 7.01, 24.58),
        ("LXYLFJ", "OAZAX", 25, 13.35, 7.14, 21.17),
        ("KMMASZ", "HNVQZ", 21, 13.27, 8.40, 18.64),
        ("T9PODS", "CIARW", 21, 12.66, 8.55, 20.00),
        ("J2WVUJ", "JYFZP", 24, 17.15, 7.60, 29.35),
        ("4RR7LF", "QQXKH", 22, 14.15, 7.15, 26.40),
        ("4HLNQ2", "TWZNB", 20, 17.38, 8.67, 22.75);

INSERT INTO manufacturer
  (m_name, m_nation, m_sales) VALUES
	("Acura", "JAPAN", 447100332),
	("Mercedes Benz", "GERMANY", 770444210),
	("Dodge", "UNITED STATES", 568757876),
	("Honda", "JAPAN", 911180816),
	("Subaru", "JAPAN", 546727696),
	("Hyundai", "SOUTH KOREA", 150124313),
	("Ford", "UNITED STATES", 979843989),
	("Rolls Royce", "UNITED KINGDOM", 417980924),
	("Volkswagen", "GERMANY", 853777697),
	("Chevrolet", "UNITED STATES", 382619531),
	("Chrysler", "UNITED STATES", 845454540),
	("Ferrari", "ITALY", 824717770),
	("Bentley", "UNITED KINGDOM", 867708422);

INSERT INTO extras
	(ex_model, ex_heated, ex_leather, ex_turbo, ex_spoiler, ex_tint, ex_convertible) VALUES
	("Legend", 0, 0, 0, 0, 0, 1),
	("M Class", 0, 0, 1, 1, 0, 0),
	("Ram Pickup", 0, 0, 0, 1, 0, 1),
	("Accord", 1, 0, 1, 0, 0, 0),
	("Integra", 1, 1, 1, 1, 0, 1),
	("Legacy", 1, 0, 1, 1, 1, 1),
	("Sonata", 1, 1, 0, 0, 0, 0),
	("Legend", 1, 1, 0, 1, 1, 0),
	("NSX", 0, 1, 0, 1, 0, 1),
	("Taurus", 0, 1, 1, 1, 0, 0),
	("Phantom", 1, 1, 0, 0, 1, 0),
	("Jetta", 1, 0, 1, 0, 1, 0),
	("Tahoe", 1, 0, 0, 0, 0, 1),
	("300C", 0, 1, 0, 1, 0, 0),
	("F355", 1, 1, 1, 1, 1, 0),
	("F430", 1, 0, 0, 1, 0, 1),
	("F430", 1, 0, 1, 1, 1, 1),
	("456M", 0, 0, 0, 0, 0, 0),
	("456", 1, 0, 1, 0, 0, 0),
	("F430", 1, 0, 1, 1, 1, 0),
	("612", 1, 0, 1, 1, 0, 1),
	("Continental GT", 1, 0, 0, 0, 1, 1),
	("Continental GT V8", 1, 0, 1, 1, 1, 1),
	("Mulsanne", 0, 0, 1, 0, 1, 1),
	("Arnage", 0, 1, 1, 0, 1, 1),
	("Continental", 1, 0, 1, 1, 1, 1),
	("Mulsanne", 0, 1, 0, 0, 0, 0),
	("Continental GT", 0, 1, 1, 0, 0, 1),

	("M Class", 0, 1, 1, 0, 1, 0),
	("Ram Pickup", 1, 1, 1, 1, 0, 1),
	("Accord", 0, 1, 1, 0, 0, 1),
	("Integra", 1, 1, 1, 0, 0, 1),
	("Legacy", 1, 1, 1, 0, 1, 1),
	("Sonata", 0, 0, 1, 0, 0, 1),
	("Legend", 1, 1, 0, 0, 0, 1),
	("NSX", 0, 0, 0, 1, 0, 1),
	("Tarus", 0, 1, 1, 0, 0, 1),
	("Phantom", 0, 0, 1, 0, 0, 0),
	("Jetta", 1, 1, 0, 0, 1, 0),
	("Tahoe", 0, 1, 0, 0, 1, 1),
	("300C", 0, 1, 1, 1, 0, 1),
	("F355", 0, 0, 1, 0, 0, 0),
	("F430 Coupe", 1, 1, 1, 0, 0, 1),
	("F430", 1, 1, 1, 0, 0, 1),
	("456M", 1, 1, 1, 1, 1, 1),
	("456", 0, 1, 1, 0, 1, 0),
	("F430 Coupe", 0, 0, 1, 0, 0, 1),
	("612", 1, 1, 1, 0, 1, 0),
	("Continental GT", 0, 1, 0, 0, 0, 1),
	("Continental GT V8", 0, 0, 1, 1, 0, 0),
	("Mulsanne", 1, 1, 1, 0, 0, 0),
	("Arnage", 0, 1, 1, 0, 1, 1),
	("Continental Flying Spur Speed", 0, 1, 1, 0, 0, 1),
	("Mulsanne", 1, 1, 0, 0, 1, 1),
	("Continental GT", 0, 1, 1, 0, 0, 1);

INSERT INTO people
	(p_license, p_phone, p_name, p_email, p_age) VALUES
	("OCB4NDCR", 5552345264, "John Smoth", "jSmith@email.com", 49),
	("X5OT7H6T", 5556392645, "Olga Buck", "oBuck@email.com", 62),
	("88JDBI64", 5559682745, "Kasi Rozalija", "kroz@email.com", 29),
	("9VSR5354", 5559529566, "Loki Sarala", "lsarala@email.com", 30),
	("0P932C9K", 5552352543, "Nergui Anu", "nanu@email.com", 31),
	("53OFLNAW", 5555902935, "Pris Wolfe", "pwolfe@email.com", 69),
	("I5RQNWC1", 5552352367, "Lisbeth Caoligon", "lcao@email.com", 71),
	("IEZQFUTS", 5559863423, "John Smoth", "jsmoth@email.com", 60),
	("29VCTAG2", 5559864332, "Marilene Sibilla", "msibilla@email.com", 58),
	("PIL8HU75", 5552353267, "Payton Prunella", "pprun@email.com", 25),
	("0Q48PSO2", 5559863235, "Ashton Jantje", "ashtonjan@email.com", 31),
	("EV0NP8X0", 5551152631, "Aggie Lucius", "alucius@email.com", 28),
	("9LP4PUQK", 5559821064, "Steen Gunda", "sgunda@email.com", 30),
	("MYPYLSPY", 5559863233, "Nori Ninian", "nninian@email.com", 36),
	("EKNNVTJ5", 5552386823, "Keelan Iris", "kiris@email.com", 48),
	("S2ZWGCJA", 5559812523, "Marci Marylou", "mmary@email.com", 54),
	("RJTHMO4U", 5559863299, "Elsa Bertoldo", "elsabert@email.com", 44),
	("L2KKDVV2", 5559217206, "Marin Lex", "marinlex@email.com", 26),
	("MWFP46S5", 5557752033, "Xavior Kinsley", "xkin@email.com", 52),
	("ARZNAC3X", 5558882593, "Karin Rearden", "krearden@email.com", 36),
	("BVOKS5QT", 5551985323, "Skyler Hilmar", "shilmar@email.com", 54),
	("UL4ZB5HT", 5559157239, "Anima Emiel", "aemiel@email.com", 34);

INSERT INTO bids
	(b_ID, b_price, b_licensePlate, b_name, b_phone) VALUES
  ("B000", 10000, "123ABC0", "John Smoth", 5552345264),
  ("B001", 20000, "123ABC1", "Olga Buck", 5556392645),
  ("B002", 53000, "123ABC2", "Kasi Rozalija", 5559682745),
  ("B003", 12000, "123ABC3", "Loki Sarala", 5559529566),
  ("B004", 24000, "123ABC4", "Nergui Anu", 5552352543),
  ("B005", 23500, "123ABC5", "Pris Wolfe", 5555902935),
  ("B006", 62000, "123ABC6", "Lisbeth Caoligon", 5552352367),
  ("B007", 32000, "123ABC7", "John Smoth", 5559863423),
  ("B008", 16000, "123ABC8", "Marilene Sibilla", 5559864332),
  ("B009", 100000, "123ABC9", "Payton Prunella", 5552353267),
  ("B010", 73000, "123ABD0", "Ashton Jantje", 5559863235),
  ("B011", 225000, "123ABD1", "Aggie Lucius", 5551152631),
  ("B012", 85000, "123ABD2", "Steen Gunda", 5559821064),
  ("B013", 92000, "123ABD3", "Nori Ninian", 5559863233),
  ("B014", 21000, "123ABD4", "Keelan Iris", 5552386823),
  ("B015", 200000, "123ABD5", "Marci Marylou", 5559812523),
  ("B016", 150000, "123ABD6", "Elsa Bertoldo", 5559863299),
  ("B017", 175000, "123ABD7", "Marin Lex", 5559217206),
  ("B018", 29500, "123ABD8", "Xavior Kinsley", 5557752033),
  ("B019", 18500, "123ABD9", "Karin Rearden", 5558882593),
  ("B020", 32000, "123ABE0", "Skyler Hilmar", 5551985323),
  ("B021", 45000, "123ABE1", "Anima Emiel", 5559157239);


--List all makers with vehicles costing moore than 100000
SELECT DISTINCT (m_name)
  FROM vehicle,
       manufacturer
 WHERE v_make = m_name AND
       v_price > 100000;

 --List the vin number of all american cars that are convertible and have a torque between 600 and 700 with a top speed higher than 200
 SELECT v_vin
   FROM vehicle,
	extras,
	hypercars,
	manufacturer,
	engine
  WHERE v_model = ex_model AND
	v_vin = h_vin AND
	v_make = m_name AND
	h_engine = e_model AND
	m_nation LIKE "UNITED STATES" AND
	h_topSpeed > 200 AND
	ex_convertible = 1 AND
	e_torque BETWEEN 600 AND 700;


--List the amount of manufacturers a country has
SELECT m_nation,
       COUNT(DISTINCT (m_name) )
  FROM manufacturer
 GROUP BY m_nation;


--Find the make, model, and year of the lightest car
SELECT v_year,
       v_make,
       v_model
  FROM hypercars,
       vehicle
 WHERE v_price IN (
           SELECT MIN(v_price) AS v_price
             FROM vehicle
       )
 GROUP BY v_vin;

--List countries who sell cars with a topspeed over 250
SELECT DISTINCT(m_nation)
FROM manufacturer, vehicle, hypercars
WHERE v_vin = h_vin AND
      h_topSpeed > 250 and
      m_name = v_make;

--Cost of all registered automatic cars from germany which have a turbo
 SELECT SUM(v_price)
   FROM vehicle,
        manufacturer,
        extras,
        transmission,
        hypercars
  WHERE v_make = m_name AND
        v_model = ex_model AND
        v_vin = h_vin AND
        h_trans = t_model AND
        m_nation LIKE "GERMANY" AND
        ex_turbo = 1 AND
        t_type = 1;


--Find how many manufacturers produce cars with heated seats and spoilers
SELECT COUNT(DISTINCT(m_name))
FROM manufacturer, vehicle, extras
WHERE v_model = ex_model AND
      m_name = v_make AND
      ex_heated = 1 AND
      ex_spoiler = 1;


--Find the year where the most expensive car was produced in USA
SELECT DISTINCT(v_year)
FROM manufacturer, vehicle, hypercars
WHERE v_vin = h_vin AND
      m_nation = "UNITED STATES" AND
      v_price = (SELECT MAX(v_price)
                 FROM vehicle);


--Find the manufacturer with the highest number of sales before the year 2000
SELECT DISTINCT(m_name)
FROM manufacturer, vehicle
WHERE v_year < 2000 AND
      m_sales = (SELECT MAX(m_sales)
                 FROM manufacturer);

--How many nations produce red vehicles that also have a spoiler
SELECT COUNT(DISTINCT(m_nation))
FROM manufacturer, extras, vehicle, hypercars
WHERE ex_vin = v_vin AND
      v_vin = h_vin AND
      v_color = "RED" AND
      ex_spoiler = 1;


--List the hypercars that have rim diameter lower than 7.68, sorted  by rim size  descending
SELECT v_year, v_make, v_model,
       w_model,
       w_rim
FROM vehicle,
     hypercars,
     wheels
 WHERE v_vin = h_vin AND
       h_wheel = w_model AND
       w_rim < 7.68
 ORDER BY w_rim DESC;


 --List all hypercars that cost less than 90000 made by Acura after the year 2000
 SELECT DISTINCT(h_vin)
 FROM hypercars, vehicle, manufacturer
 WHERE h_vin = v_vin AND
       v_make = m_name AND
       v_price < 90000 AND
       v_year > 2000;


--List hypercars with 6 gears and no turbo are made by Mercedes Benz
SELECT DISTINCT(h_vin)
FROM hypercars, manufacturer, extras, transmission, vehicle
WHERE t_gears = 6 AND
      ex_turbo = 1 AND
      m_name = "Mercedes Benz" AND
      v_make = m_name AND
      h_vin = v_vin AND
      ex_vin = v_vin;

--List all the cars with the most popular colors
SELECT v_year,
       v_make,
       v_model,
       v_color
FROM vehicle
WHERE v_color IN (
           SELECT v_color
             FROM (
                      SELECT v_color,
                             count( * ) AS sum
                        FROM vehicle
                       GROUP BY v_color
                  )
                  AS colorCount
            WHERE sum IN (
                      SELECT MAX(sum)
                        FROM (
                                 SELECT v_color,
                                        count( * ) AS sum
                                   FROM vehicle
                                  GROUP BY v_color
                             )
                  )
       )
 GROUP BY v_color,
          v_vin;

--Update a car's color
UPDATE vehicle
   SET v_color = 'RED'
 WHERE v_vin = '1GNEK13T7YJ204464';


 --Out of all hypercars that have engines larger than 5, made in Germany, and are not tinted which one is the fastest?
 SELECT DISTINCT(h_vin)
 FROM hypercars, manufacturer, engine, extras
 WHERE h_vin = ex_vin AND
       m_nation = "GERMANY" AND
       e_size > 5 AND
       ex_tint = 0 AND
       h_topSpeed = (SELECT h_topSpeed
                     FROM hypercars);

 --List countries that produce manual hypercars with heated seats and a top speed of less than 150
 SELECT DISTINCT(m_nation)
 FROM manufacturer, extras, hypercars, transmission, vehicle
 WHERE h_topSpeed < 150 AND
       ex_heated = 1 AND
       t_type = 1 AND
       v_make = m_name AND
       h_vin = v_vin;

 --Find the wheel and engine model of the fastest car produced in JAPAN before the year 2000
 SELECT (w_model, e_model
 FROM engine, wheels, hypercars, manufacturer, vehicle
 WHERE e_model = h_engine AND
       w_model = h_wheel AND
       m_nation = "JAPAN" AND
       v_vin = h_vin AND
       v_year < 2000 AND
       h_topSpeed = (SELECT MAX(h_topSpeed)
                     FROM hypercars);

 --Find the slowest car with a v12 engines
 SELECT v_year, v_make, v_model, h_topSpeed
   FROM vehicle,
        hypercars,
        engine
  WHERE v_vin = h_vin AND
        h_engine = e_model AND
        e_cylinders = 12 AND
        h_topSpeed IN (
            SELECT MIN(h_topSpeed)
              FROM hypercars,
                   engine
             WHERE h_engine = e_model AND
                   e_cylinders = 12
        );
--Find the average price of all the cars of of the maker with most cars in the database
SELECT maker,
       ROUND(AVG(v_price), 2)
  FROM (
           SELECT v_make AS maker,
                  MAX(cnt)
             FROM (
                      SELECT v_make,
                             Count(v_make) AS cnt
                        FROM vehicle
                       GROUP BY v_make
                  )
       ),
       vehicle
 WHERE v_make = maker;


 --List all the maker and cylinders of all engines with hp ranging from AVG to MAX
 SELECT h_vin,
        e_make,
        e_cylinders,
        h_topSpeed
   FROM engine,
        hypercars
  WHERE h_engine = e_model AND
        e_hp BETWEEN (
                         SELECT AVG(e_hp)
                           FROM engine
                     )
        AND (
                SELECT MAX(e_hp)
                  FROM engine
            )
  GROUP BY h_vin
  ORDER BY h_topSpeed;



  --List everyone who placed a bid of at least $10,000 for a black car
  SELECT p_name
  FROM people,
       bids,
       vehicle,
 WHERE b_price >= 10000 AND
       b_phone = p_phone AND
       b_licensePlate = v_license AND
       v_color = "BLACK";



  --Find the phone number of the person who placed the highest bid on a car from GERMANY
  SELECT DISTINCT(p_phone)
  FROM people,
       bids,
       manufacturer,
       vehicle
  WHERE p_phone = b_phone AND
        b_licensePlate = v_license AND
        m_nation = "GERMANY" AND
        b_price = (SELECT MAX(b_price)
                   FROM bids);

  --For those who placed bids under $50,000, what is the email and driver's licnce of the person who placed a bid for a car with tinted windows
  SELECT DISTINCT(p_email), p_license
  FROM people,
       bids,
       extras,
       vehicle
  WHERE p_phone = b_phone AND
        b_price < 50000 AND
        ex_tint = 1 AND
        ex_model = v_model;

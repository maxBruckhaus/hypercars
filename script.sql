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
        (1,2,3,4,5,6,7),
        (1,2,3,4,5,6,7);
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

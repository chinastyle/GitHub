/*
 * RuningLED.c
 *
 * Created: 2013-12-7 17:35:49
 *  Author: Administrator
 */ 

#include <avr/io.h>
#define F_CPU 16000000 // ����16Mhz
#include <util/delay.h>

#define  SLEEP_MS 100 //led��ˮ�����Ͳ���ʱ�� ���
#define  LED_NUM 8 //LED�Ƹ���

int main(void)
{
	DDRD |= 0xFF;
	PORTD = 0xFF;
	int i ;
	while(1)
	{

		//��0-7��
		
		for (i = 0;i < LED_NUM; i++)
		{
			PORTD &= (~(1<<i));
			_delay_ms(SLEEP_MS);
		}

		//��7-0Ϩ
		for (i --;i >=0 ; i--)
		{
			PORTD |= (1<<i);
			_delay_ms(SLEEP_MS);
		}
		
		//��7-0��
		
		for (i = 7;i >= 0; i--)
		{
			PORTD &= (~(1<<i));
			_delay_ms(SLEEP_MS);
		}

		//��0-7Ϩ
		for (i ++; i < LED_NUM ; i++)
		{
			PORTD |= (1<<i);
			_delay_ms(SLEEP_MS);
		}
		
		
	}
}